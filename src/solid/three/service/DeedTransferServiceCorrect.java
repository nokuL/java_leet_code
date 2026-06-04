package solid.three.service;

import solid.three.model.Deed;
import solid.three.model.DeedStatus;
import solid.three.repository.DeedRepository;

public class DeedTransferServiceCorrect {

    private final DeedRepository deedRepository;
    private final INationalIdService nationalIdService;
    private final PaymentProcessorFactory paymentProcessorFactory;
    private final IMessageProcessor messageProcessor;
    private final IAuditService auditService;

    public DeedTransferServiceCorrect(DeedRepository deedRepository,
                                      INationalIdService nationalIdService,
                                      PaymentProcessorFactory paymentProcessorFactory,
                                      IMessageProcessor messageProcessor,
                                      IAuditService auditService) {
        this.deedRepository = deedRepository;
        this.nationalIdService = nationalIdService;
        this.paymentProcessorFactory = paymentProcessorFactory;
        this.messageProcessor = messageProcessor;
        this.auditService = auditService;
    }

    public String processDeedTransfer(String deedId, String newOwnerNationalId, String paymentMethod) {

        Deed deed = deedRepository.findDeedById(deedId);
        if (deed == null) {
            return "FAILED: Deed not found";
        }

        boolean isIdValid = nationalIdService.validateiD(newOwnerNationalId);
        if (!isIdValid) {
            return "FAILED: Invalid ID supplied";
        }
/// THis is Liskov Princi, i can whatever is returned should still work
        IPaymentProcessor processor = paymentProcessorFactory.getProcessor(paymentMethod);
        processor.processPayment(newOwnerNationalId);

        deed.setStatus(DeedStatus.TRANSFERRED);
        deed.setOwnerNationalId(newOwnerNationalId);

        messageProcessor.sendMessage("Deed " + deedId + " has been transferred to " + newOwnerNationalId);

        auditService.audit(deedId, newOwnerNationalId);

        return "SUCCESS";
    }
}

//S --- Single Responsibility: the smelly class was doing too much in one method — fetching the deed, validating the ID, processing payment,
//      updating deed state, sending a notification, and writing an audit log. Fixed by extracting each concern into its own service:
//      INationalIdService validates, IPaymentProcessor handles payment, IMessageProcessor sends notifications, IAuditService logs.
//      DeedTransferServiceCorrect now only orchestrates — it does not know how any of those things are done.

//O --- Open/Closed: the smelly code had hardcoded if/else blocks for ECOCASH and IVERI inside the method. Adding a new payment method
//      meant modifying this class. Fixed by introducing the IPaymentProcessor interface — EcocashProcessor and IveriProcessor each
//      provide their own implementation. PaymentProcessorFactory selects the right one. To add a new payment method, you just add
//      a new class and register it in the factory — no changes to DeedTransferServiceCorrect.

//L --- Liskov Substitution: EcocashProcessor and IveriProcessor both implement IPaymentProcessor. Either can be returned by
//      PaymentProcessorFactory and used by DeedTransferServiceCorrect without it knowing or caring which one it got.
//      Swapping one for the other does not break the calling code — each honours the same contract.

//I --- Interface Segregation: each interface has one focused responsibility. INationalIdService only validates,
//      IAuditService only audits, IMessageProcessor only sends messages, IPaymentProcessor only processes payment.
//      No implementor is forced to provide methods it does not need. Compare this to the smelly version where
//      DeedRepository was the only dependency and it was being stretched to do everything.

//D --- Dependency Inversion: the smelly class depended directly on concrete behaviour (inline System.out.println for payment,
//      notification, and audit). DeedTransferServiceCorrect depends only on abstractions injected through the constructor.
//      The high-level orchestration logic is completely decoupled from low-level details like how EcoCash dials USSD
//      or how the audit log is written.