package org.example;

import org.example.customers.Customer;
import org.example.customers.CustomersDB;
import org.example.mobiles.Mobiles;
import org.example.mobiles.MobilesDB;
import org.example.payments.PaymentDB;
import org.example.payments.Payments;
import org.example.repairs.Repairs;
import org.example.repairs.RepairsDB;

import java.util.Scanner;

import static org.example.customers.CustomerManager.*;
import static org.example.customers.CustomersDB.GetCustomers;
import static org.example.mobiles.MobilesDB.GetMobiles;
import static org.example.payments.PaymentDB.GetPayments;
import static org.example.repairs.RepairsDB.GetRepairs;

public class Main {

    private static Customer selectedUser = null;
    public static final Scanner scanner = new Scanner(System.in);

    //String selectedUsername = selectedUser == null ? "NONE" : selectedUser.first_name;

    public static void main(String[] args) {

        while(true){
            System.out.println("Welcome to the phone repair app");
            System.out.println("Press 1 to input who you are: ");
            System.out.println("Press 0 to exit");
            String optionOne = scanner.nextLine();

            if (optionOne.equals("1")){
                selectCustomer();
            } else if (optionOne.equals("0")) {
                System.exit(0);
            } else {
                System.out.println("Not a valid input");
            }
            System.out.println("Welcome " + selectedUser.first_name);
            System.out.println("what do you want to do?");
            System.out.println("1. go to customers");
            System.out.println("2. go to mobiles");
            System.out.println("3. go to repairs");
            System.out.println("4. go to payments");
            String optionTwo = String.valueOf(scanner.nextInt());

            if (optionTwo.equals("1")){
                customerMenu();
            }
            else if (optionTwo.equals("2")){
                mobilesMenu();
            }
            else if (optionTwo.equals("3")){
                repairsMenu();
            }
            else if (optionTwo.equals("4")){
                paymentsMenu();
            }else {
                System.out.println("Not a valid input");
            }
        }
    }
    private static void customerMenu(){
        String customerOption = getCustomerOption();

        switch (customerOption) {
            case "1" -> System.out.println(GetCustomers());
            case "2" -> addCustomer();
            case "3" -> updateCustomer();
            case "4" -> deleteCustomerMethod();
            default -> System.exit(0);
        }
    }

    private static void mobilesMenu(){
        System.out.println("welcome to the mobile menu");
        System.out.println("1. to look at our mobile");
        System.out.println("2. to add a mobile");
        System.out.println("3. to update a mobile");
        System.out.println("4. to delete a mobile");
        System.out.println("or 5 to exit");
        String mobileMenu = String.valueOf(scanner.nextInt());

        if (mobileMenu.equals("1")){
            System.out.println(GetMobiles());

        }else if (mobileMenu.equals("2")) {
            System.out.println("Enter new mobile details: ");
            System.out.println("brand name: ");
            String brandName = scanner.next();
            System.out.println("model name: ");
            String modelName = scanner.next();

            Mobiles mobiles = new Mobiles(brandName,modelName);
            boolean isCustomerAdded = MobilesDB.addMobile(mobiles);

            if (isCustomerAdded){
                System.out.println("Mobile Added successfully");
            }else {
                System.out.println("Failed to add The new mobile");
            }

        }else if (mobileMenu.equals("3")){
            System.out.println("Update mobile-info.");
            System.out.println("Enter the id of the mobile you wanna update: ");
            int mobileId = scanner.nextInt();
            System.out.println("Enter your new brand name: ");
            String brandName = scanner.next();
            System.out.println("Enter your new model name: ");
            String modelName = scanner.next();

            Mobiles mobiles = new Mobiles(mobileId,brandName,modelName);
            boolean isMobileUpdated = MobilesDB.updateMobile(mobiles);

            if (isMobileUpdated){
                System.out.println("Mobile info updated successfully");
            }else {
                System.out.println("Failed to update Mobile info");
            }

            }else if (mobileMenu.equals("4")){
            System.out.println("Delete a mobile");
            System.out.println("Enter the mobile id you wanna delete: ");
            int mobileId = scanner.nextInt();

            boolean isMobileDeleted = MobilesDB.deleteMobile(mobileId);

            if (isMobileDeleted){
                System.out.println("You successfully deleted the mobile");
            }else {
                System.out.println("Failed to delete the mobile");
            }
            }else {
            System.exit(0);
            }
    }

    private static void paymentsMenu(){
        System.out.println("welcome to the payments menu");
        System.out.println("1. to look at our payments");
        System.out.println("2. to add a payments");
        System.out.println("3. to update a payments");
        System.out.println("4. to delete a payments");
        System.out.println("or 5 to exit");
        String paymentOption = String.valueOf(scanner.nextInt());

        if (paymentOption.equals("1")){
            System.out.println(GetPayments());

        }else if (paymentOption.equals("2")) {
            System.out.println("Enter new payment details: ");
            System.out.println("amount_due: ");
            int amount_due = scanner.nextInt();
            System.out.println("payment_method: ");
            String payment_method = scanner.next();
            System.out.println("payment_date: ");
            String payment_date = scanner.next();
            System.out.println("Here comes the repairs, if u was unsure about the repair id");
            System.out.println(GetRepairs());
            System.out.println("and here is the customers");
            System.out.println(GetCustomers());
            System.out.println("repair_id: ");
            int repair_id = scanner.nextInt();

            Payments payments = new Payments(amount_due, payment_method, payment_date, repair_id);
            boolean isPaymentAdded = PaymentDB.addPayment(payments);

            if (isPaymentAdded) {
                System.out.println("Payment Added successfully");
            } else {
                System.out.println("Failed to add The new payment");
            }

        }else if (paymentOption.equals("3")){
            System.out.println("Update Payment-info.");
            System.out.println("Enter the id of the payment you wanna update: ");
            int paymentId = scanner.nextInt();
            System.out.println("amount_due: ");
            int amount_due = scanner.nextInt();
            System.out.println("payment_method: ");
            String payment_method = scanner.next();
            System.out.println("payment_date: ");
            String payment_date = scanner.next();
            System.out.println("repair_id: ");
            int repair_id = scanner.nextInt();

            Payments payments = new Payments(paymentId,amount_due,payment_method,payment_date,repair_id);
            boolean isPaymentUpdated = PaymentDB.updatePayment(payments);

            if (isPaymentUpdated){
                System.out.println("Payment info updated successfully");
            }else {
                System.out.println("Failed to update the payment info");
            }
        }else if (paymentOption.equals("4")){
            System.out.println("Delete a payment");
            System.out.println("Enter the payment id you wanna delete: ");
            int paymentId = scanner.nextInt();

            boolean isPaymentDeleted = PaymentDB.deletePayment(paymentId);

            if (isPaymentDeleted){
                System.out.println("You successfully deleted the payment");
            }else {
                System.out.println("Failed to delete the payment");
            }
        }else {
            System.exit(0);
        }
    }




///////////// REPAIRSSSSSSSSSS


    private static void repairsMenu(){
        System.out.println("welcome to the repair menu");
        System.out.println("1. to look at our repairs");
        System.out.println("2. to add a repair");
        System.out.println("3. to update a repair");
        System.out.println("4. to delete a repair");
        System.out.println("or 5 to exit");
        String customerOption = String.valueOf(scanner.nextInt());

        if (customerOption.equals("1")){
            System.out.println(GetRepairs());


        }else if (customerOption.equals("2")) {
            System.out.println("Enter new repairs details: ");
            System.out.println("repair cost: ");
            int repair_cost = scanner.nextInt();
            System.out.println("repair start: ");
            String repair_start = scanner.next();
            System.out.println("repair finished: ");
            String repair_finished = scanner.next();
            System.out.println("enter the customer you wanna add it to");
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

        }else if (customerOption.equals("3")){
            System.out.println("Update Repair-info.");
            System.out.println("Enter the id of the Repair you wanna update: ");
            int repairId = scanner.nextInt();
            System.out.println("repair cost: ");
            int repair_cost = scanner.nextInt();
            System.out.println("repair start:: ");
            String repair_start = scanner.next();
            System.out.println("repair finished: ");
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


        }else if (customerOption.equals("4")){
            System.out.println("Delete a repair");
            System.out.println("Enter the repair id you wanna delete: ");
            int repairId = scanner.nextInt();

            boolean isRepairDeleted = RepairsDB.deleteRepair(repairId);

            if (isRepairDeleted){
                System.out.println("You successfully deleted the repair");
            }else {
                System.out.println("Failed to delete the repair");
            }
        }else {
            System.exit(0);
        }
    }









    private static void selectCustomer(){
        var CustomerDB = new CustomersDB();
        var customers = CustomerDB.GetCustomers();

        for (var customer: customers){
            System.out.println(customer);
        }

        System.out.println("Select user: ");
        var customerId = scanner.nextInt();

        for (var customer: customers){
            if (customerId == customer.customer_id){
                selectedUser = customer;
                break;
            }
        }
    }
}