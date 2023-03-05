package org.example;

import org.example.customers.Customer;
import org.example.customers.CustomersDB;

import java.util.Scanner;

import static org.example.customers.CustomerManager.*;
import static org.example.customers.CustomersDB.GetCustomers;
import static org.example.mobiles.MobilesDB.GetMobiles;
import static org.example.mobiles.MobilesManager.*;
import static org.example.payments.PaymentDB.GetPayments;
import static org.example.payments.PaymentsManager.*;
import static org.example.repairs.RepairsDB.GetRepairs;
import static org.example.repairs.RepairsManager.*;

public class Main {

    private static Customer selectedUser = null;
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true){
            System.out.println("Welcome to the phone repair app");
            System.out.println("Press 1 to start: ");
            System.out.println("Press 0 to exit");
            String optionOne = String.valueOf(scanner.nextInt());

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

            switch (optionTwo) {
                case "1" -> customerMenu();
                case "2" -> mobilesMenu();
                case "3" -> repairsMenu();
                case "4" -> paymentsMenu();
                default -> System.out.println("Not a valid input");
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
        String mobileMenu = welcomeMenuMobile();

        switch (mobileMenu) {
            case "1" -> System.out.println(GetMobiles());
            case "2" -> addNewMobile();
            case "3" -> updateMobileInfo();
            case "4" -> deleteMobileMenu();
            default -> System.exit(0);
        }
    }

    private static void paymentsMenu(){
        String paymentOption = welcomeMenuPayments();

        switch (paymentOption) {
            case "1" -> System.out.println(GetPayments());
            case "2" -> addPayments();
            case "3" -> updatePaymentsMethod();
            case "4" -> deletePaymentMethod();
            default -> System.exit(0);
        }
    }

    private static void repairsMenu(){
        String repairOption = repairsWelcomeMenu();

        switch (repairOption) {
            case "1" -> System.out.println(GetRepairs());
            case "2" -> addRepairs();
            case "3" -> updateRepairsMethod();
            case "4" -> deleteRepairsMethod();
            default -> System.exit(0);
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