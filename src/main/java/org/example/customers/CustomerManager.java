package org.example.customers;

import static org.example.Main.scanner;

public class CustomerManager {
    public static void addCustomer() {
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
    }
    public static void updateCustomer() {
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
    }
    public static void deleteCustomerMethod() {
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
    public static String getCustomerOption() {
        System.out.println("welcome to the customer menu");
        System.out.println("1. to look at our customers");
        System.out.println("2. to add a customer");
        System.out.println("3. to update a customer");
        System.out.println("4. to delete a customer");
        System.out.println("or 5 to exit");
        String customerOption = String.valueOf(scanner.nextInt());
        return customerOption;
    }
}
