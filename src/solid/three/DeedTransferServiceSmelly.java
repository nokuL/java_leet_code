package solid.three;

import solid.three.model.Deed;
import solid.three.model.DeedStatus;
import solid.three.repository.DeedRepository;

import java.util.Date;
import java.util.List;

public class DeedTransferServiceSmelly {

   private final DeedRepository deedRepository;

    public DeedTransferServiceSmelly(DeedRepository deedRepository) {
        this.deedRepository = deedRepository;
    }

    public String processDeedTransfer(String deedId, String newOwnerNationalId, String paymentMethod) {


        Deed deed = deedRepository.findDeedById(deedId);


        if (deed == null) {;
            return "FAILED: Deed not found";
        }

        // 2. Validate new owner inline
        if (newOwnerNationalId == null || newOwnerNationalId.length() != 11) {
            return "FAILED: Invalid National ID";
        }
        if (!newOwnerNationalId.matches("[0-9]+")) {
            return "FAILED: National ID must be numeric";
        }

        // 3. Payment processing baked right in
        if (paymentMethod.equals("ECOCASH")) {
            System.out.println("Dialing EcoCash USSD for " + newOwnerNationalId);
            // hardcoded EcoCash logic here
        } else if (paymentMethod.equals("IVERI")) {
            System.out.println("Calling iVeri 3DS for " + newOwnerNationalId);
            // hardcoded iVeri logic here
        } else {
            return "FAILED: Unknown payment method";
        }

        // 4. Update deed state directly
        deed.setStatus(DeedStatus.TRANSFERRED); // fixed raw String smell too
        deed.setOwnerNationalId(newOwnerNationalId);

        // 5. Send notification inline
        if (newOwnerNationalId.startsWith("26")) {
            System.out.println("Sending SMS to Zimbabwe number...");
        } else {
            System.out.println("Sending email notification...");
        }

        // 6. Write audit log inline
        System.out.println("AUDIT: Deed " + deedId +
                " transferred to " + newOwnerNationalId +
                " at " + new Date());

        return "SUCCESS";
    }
}

//S --- Single Responsibility Principle violated, class is doing too much, payments, sending notifcation, audit , validating ID