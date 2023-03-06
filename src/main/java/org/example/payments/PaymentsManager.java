package org.example.payments;

import static org.example.Main.scanner;

public class PaymentsManager {

    public static String welcomeMenuPayments() {
        System.out.println("welcome to the payments menu");
        System.out.println("1. to look at our unpaid payments");
        System.out.println("2. to add a payments");
        System.out.println("3. to update a payments");
        System.out.println("4. to delete a payments");
        System.out.println("or 5 to exit");
        String paymentOption = String.valueOf(scanner.nextInt());
        return paymentOption;
    }

    public static void addPayments() {
        System.out.println("Enter new payment details: ");
        System.out.println("The amount to pay: ");      // amount_due is the repair cost for the customer
        int amount_due = scanner.nextInt();
        System.out.println("What payment method do you want use?: ");
        String payment_method = scanner.next();
        System.out.println("What date do you want to pay?: ");
        String payment_date = scanner.next();
        System.out.println("Enter the repair id of the payment: ");
        int repair_id = scanner.nextInt();

        Payments payments = new Payments(amount_due, payment_method, payment_date, repair_id);
        boolean isPaymentAdded = PaymentDB.addPayment(payments);

        if (isPaymentAdded) {
            System.out.println("Payment Added successfully");
        } else {
            System.out.println("Failed to add The new payment");
        }
    }

    public static void updatePaymentsMethod() {
        System.out.println("Update Payment-info.");
        System.out.println("Enter the id of the payment you wanna update: ");
        int paymentId = scanner.nextInt();
        System.out.println("The amount to pay: ");
        int amount_due = scanner.nextInt();
        System.out.println("What payment method do you want use?: ");
        String payment_method = scanner.next();
        System.out.println("What date do you want to pay?: ");
        String payment_date = scanner.next();
        System.out.println("Enter the repair id of the payment: ");
        int repair_id = scanner.nextInt();

        Payments payments = new Payments(paymentId,amount_due,payment_method,payment_date,repair_id);
        boolean isPaymentUpdated = PaymentDB.updatePayment(payments);

        if (isPaymentUpdated){
            System.out.println("Payment info updated successfully");
        }else {
            System.out.println("Failed to update the payment info");
        }
    }

    public static void deletePaymentMethod() {
        System.out.println("Delete a payment");
        System.out.println("Enter the payment id you wanna delete: ");
        int paymentId = scanner.nextInt();

        boolean isPaymentDeleted = PaymentDB.deletePayment(paymentId);

        if (isPaymentDeleted){
            System.out.println("You successfully deleted the payment");
        }else {
            System.out.println("Failed to delete the payment");
        }
    }



}
