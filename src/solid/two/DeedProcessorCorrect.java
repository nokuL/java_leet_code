package solid.two;

import solid.two.service.ClerkType;
import solid.two.service.IClerkAssignmentService;
import solid.two.service.IDeedRepository;
import solid.two.service.IDeedValidationService;
import solid.two.service.IFeeCalculationService;
import solid.two.service.INotificationService;
import solid.two.service.IPaymentService;

public class DeedProcessorCorrect {

    private final IDeedValidationService validationService;
    private final IFeeCalculationService feeCalculationService;
    private final IPaymentService paymentService;
    private final IClerkAssignmentService clerkAssignmentService;
    private final IDeedRepository deedRepository;
    private final INotificationService notificationService;

    public DeedProcessorCorrect(IDeedValidationService validationService,
                                IFeeCalculationService feeCalculationService,
                                IPaymentService paymentService,
                                IClerkAssignmentService clerkAssignmentService,
                                IDeedRepository deedRepository,
                                INotificationService notificationService) {
        this.validationService = validationService;
        this.feeCalculationService = feeCalculationService;
        this.paymentService = paymentService;
        this.clerkAssignmentService = clerkAssignmentService;
        this.deedRepository = deedRepository;
        this.notificationService = notificationService;
    }

    public void processDeed(String deedType, String ownerName,
                            String ownerEmail, String ownerPhone,
                            double propertyValue, String paymentMethod,
                            String paymentRef, boolean isVip,
                            boolean isUrgent, String assignedClerk) {

        boolean isValid = validationService.validate(ownerName, ownerEmail, propertyValue);
        if (!isValid) return;

        double fee = feeCalculationService.calculateFee(deedType, propertyValue, isUrgent, isVip);

        paymentService.processPayment(paymentMethod, ownerPhone, paymentRef, fee);

        ClerkType clerk = clerkAssignmentService.assignClerk(assignedClerk, isVip);

        deedRepository.save(ownerName, deedType, fee, clerk);

        notificationService.notify(ownerEmail, ownerPhone);
    }
}

//S --- Single Responsibility: the smelly class had one method doing everything — validating, calculating fees, applying surcharges,
//      processing payment, assigning a clerk, saving, and notifying. Each concern is now its own service:
//      IDeedValidationService validates input, IFeeCalculationService computes the fee including urgency and VIP modifiers,
//      IPaymentService processes payment, IClerkAssignmentService picks the clerk, IDeedRepository saves,
//      and INotificationService sends email and SMS. DeedProcessorCorrect only orchestrates — it does not know how any of it works.

//O --- Open/Closed: three if/else blocks were hardcoded in the smelly class — one for deed type fees, one for payment methods,
//      and one for urgency/VIP. Adding a new deed type or payment method meant modifying this class.
//      Fixed with IDeedTypeProcessor (TransferFeeCalculator, MortgageFeeCalculator, CancellationFeeCalculator) and
//      IPaymentProcessor (EcocashPaymentProcessor, IveriPaymentProcessor, CashPaymentProcessor), each selected by a factory.
//      Adding a new deed type or payment method means a new class and one line in the factory — DeedProcessorCorrect is never touched.

//L --- Liskov Substitution: any implementation of IDeedTypeProcessor, IPaymentProcessor, or INotificationService can be swapped in
//      without breaking DeedProcessorCorrect. For example, replacing EcocashPaymentProcessor with a new mobile money processor
//      still honours the IPaymentProcessor contract — the calling code does not need to change.

//I --- Interface Segregation: each interface is small and focused on one job. IDeedValidationService only validates,
//      IClerkAssignmentService only assigns clerks, IDeedRepository only saves. No implementor is forced to provide
//      methods unrelated to its role. Compare to the smelly version where one class was responsible for all of it.

//D --- Dependency Inversion: the smelly class depended directly on concrete logic inlined in the method — hardcoded System.out.println
//      calls for payment, saving, and notification. DeedProcessorCorrect depends only on abstractions injected through the constructor.
//      The high-level orchestration is completely decoupled from low-level details like how EcoCash is called or how the deed is saved.