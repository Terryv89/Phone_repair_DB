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
            String optionTwo = scanner.nextLine();

            if (optionTwo.equals("1")){
                customerMenu();
            }
            else if (optionTwo.equals("3")){
                //mobilesMenu();
            }
            else if (optionTwo.equals("4")){
                //repairsMenu();
            }
            else if (optionTwo.equals("5")){
                //paymentsMenu();
            }else {
                System.out.println("Not a valid input");
            }
        }

    }
    private static int customerMenu(){
        System.out.println("welcome to the customer menu");
        System.out.println("1. to look at our customers");
        System.out.println("2. to add a customer");
        System.out.println("3. to update a customer");
        System.out.println("4. to delete a customer");
        System.out.println("or 5 to exit");
        String customerOption = scanner.nextLine();
        if(customerOption.equals("1")){
            GetCustomers();
        }
        return -1;
    }


    private static void selectCustomer(){
        var CustomerDB = new CustomersDB();
        var customers = GetCustomers();

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