package org.example;

import org.example.customers.Customer;
import org.example.customers.CustomersDB;

import java.util.Scanner;

import static org.example.customers.CustomersDB.GetCustomers;

public class Main {

    private static Customer selectedUser = null;
    private static final Scanner scanner = new Scanner(System.in);

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
                //mobilesMenu();
            }
            else if (optionTwo.equals("3")){
                //repairsMenu();
            }
            else if (optionTwo.equals("4")){
                //paymentsMenu();
            }else {
                System.out.println("Not a valid input");
            }
        }
    }
    private static void customerMenu(){
        System.out.println("welcome to the customer menu");
        System.out.println("1. to look at our customers");
        System.out.println("2. to add a customer");
        System.out.println("3. to update a customer");
        System.out.println("4. to delete a customer");
        System.out.println("or 5 to exit");
        String customerOption = String.valueOf(scanner.nextInt());

        if(customerOption.equals("1")){
            System.out.println(GetCustomers());
        } else if (customerOption.equals("2")){
            System.out.println("Enter new customer details: ");
            System.out.println("First name: ");
            String firstName = scanner.next();
            System.out.println("Last name: ");
            String lastName = scanner.next();
            System.out.println("Phone number: ");
            int phoneNumber = scanner.nextInt();

            Customer customer = new Customer(firstName,lastName,phoneNumber);
            boolean isCustomerAdded = CustomersDB.addCustomer(customer);

            if (isCustomerAdded){
                System.out.println("Customer Added successfully");
            }else {
                System.out.println("Failed to add customer");
            }

        } else if (customerOption.equals("3")) {
            System.out.println("Update customer-info.");
            System.out.println("Enter the id of the customer you wanna update: ");
            int customerId = scanner.nextInt();
            System.out.println("Enter your new first name: ");
            String firstName = scanner.next();
            System.out.println("Enter your new last name: ");
            String lastName = scanner.next();
            System.out.println("Enter your new phone number: ");
            int phoneNumber = scanner.nextInt();

            Customer customer = new Customer(customerId,firstName,lastName,phoneNumber);
            boolean isCustomerUpdated = CustomersDB.updateCustomer(customer);

            if (isCustomerUpdated){
                System.out.println("Customer updated successfully");
            }else {
                System.out.println("Failed to update customer");
            }

        } else if (customerOption.equals("4")) {
            System.out.println("Delete a customer");
            System.out.println("Enter the customer id you wanna delete: ");
            int customerId = scanner.nextInt();

            boolean isCustomerDeleted = CustomersDB.deleteCustomer(customerId);

            if (isCustomerDeleted){
                System.out.println("You successfully deleted the customer");
            }else {
                System.out.println("Failed to delete the customer");
            }

        }
    }
    private static void selectCustomer(){
        var CustomerDB = new CustomersDB();
        var customers = CustomerDB.GetCustomers();

        for (var customer: customers){
            System.out.println(customer);
        }

        System.out.println("Select user: ");
        var customerid = scanner.nextInt();

        for (var customer: customers){
            if (customerid == customer.customer_id){
                selectedUser = customer;
                break;
            }
        }
    }
}