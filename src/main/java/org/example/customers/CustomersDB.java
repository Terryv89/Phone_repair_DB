package org.example.customers;

import org.example.DataBase.DBmanager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomersDB extends DBmanager {

    public static List<Customer> GetCustomers() {
        List<Customer> customers = new ArrayList<>();

        try {

            String query = " SELECT * FROM customers;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int phone_number = resultSet.getInt("phone_number");

                Customer customer = new Customer(customer_id, first_name,
                        last_name,phone_number);

                customers.add(customer);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }

    public boolean addCustomer(Customer customer) {
        boolean isCustomerAdded = false;

        try {
            String query = "INSERT INTO customers (first_name, last_name," +
                    " phone_number) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, customer.getFirst_name());
            statement.setString(2, customer.getLast_name());
            statement.setInt(3, customer.getPhone_number());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                isCustomerAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCustomerAdded;
    }

    public boolean updateCustomer(Customer customer) {
        boolean isCustomerUpdated = false;

        try {
            String query = "UPDATE customers SET first_name=?, last_name=?," +
                    " phone_number=? WHERE customer_id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, customer.getFirst_name());
            statement.setString(2, customer.getLast_name());
            statement.setInt(3, customer.getPhone_number());
            statement.setInt(4, customer.getCustomer_id());
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                isCustomerUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isCustomerUpdated;
    }

    public boolean deleteCustomer(int customerId) {
        boolean isCustomerDeleted = false;

        try {
            String query = "DELETE FROM customers WHERE customer_id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, customerId);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                isCustomerDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isCustomerDeleted;
    }




}
