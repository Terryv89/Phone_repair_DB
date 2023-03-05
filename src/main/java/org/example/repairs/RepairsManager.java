package org.example.repairs;

import static org.example.Main.scanner;

public class RepairsManager {

    public static String repairsWelcomeMenu() {
        System.out.println("welcome to the repair menu");
        System.out.println("1. to look at our repairs");
        System.out.println("2. to add a repair");
        System.out.println("3. to update a repair");
        System.out.println("4. to delete a repair");
        System.out.println("or 5 to exit");
        String repairOption = String.valueOf(scanner.nextInt());
        return repairOption;
    }

    public static void addRepairs() {
        System.out.println("Enter new repairs details: ");
        System.out.println("How much is the repair cost: ");  // repaircost is the cost of the repair for the business
        int repair_cost = scanner.nextInt();
        System.out.println("When does the repair start: ");
        String repair_start = scanner.next();
        System.out.println("When is the repair finished: ");
        String repair_finished = scanner.next();
        System.out.println("enter the customer you want to add it to");
        int customer_id = scanner.nextInt();
        System.out.println("and the mobile id: ");
        int mobile_id = scanner.nextInt();

        Repairs repairs = new Repairs(repair_cost, repair_start, repair_finished, customer_id, mobile_id);
        boolean isRepairAdded = RepairsDB.addRepair(repairs);

        if (isRepairAdded) {
            System.out.println("Repair Added successfully");
        } else {
            System.out.println("Failed to add The new Repair");
        }
    }
    public static void updateRepairsMethod() {
        System.out.println("Update Repair-info.");
        System.out.println("Enter the id of the Repair you wanna update: ");
        int repairId = scanner.nextInt();
        System.out.println("How much is the new repair cost: ");
        int repair_cost = scanner.nextInt();
        System.out.println("When does the repair start: ");
        String repair_start = scanner.next();
        System.out.println("When is the repair finished: ");
        String repair_finished = scanner.next();
        System.out.println("enter the customer you wanna add it to");
        int customer_id = scanner.nextInt();
        System.out.println("and the mobile id: ");
        int mobile_id = scanner.nextInt();

        Repairs repairs = new Repairs(repairId,repair_cost,repair_start,repair_finished,customer_id,mobile_id);
        boolean isRepairUpdated = RepairsDB.updateRepair(repairs);

        if (isRepairUpdated){
            System.out.println("Payment info updated successfully");
        }else {
            System.out.println("Failed to update the payment info");
        }
    }

    public static void deleteRepairsMethod() {
        System.out.println("Delete a repair");
        System.out.println("Enter the repair id you wanna delete: ");
        int repairId = scanner.nextInt();

        boolean isRepairDeleted = RepairsDB.deleteRepair(repairId);

        if (isRepairDeleted){
            System.out.println("You successfully deleted the repair");
        }else {
            System.out.println("Failed to delete the repair");
        }
    }

}
