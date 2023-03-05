package org.example.payments;

import org.example.DataBase.DBmanager;
import org.example.customers.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentDB extends DBmanager {

    public static List<Payments> GetPayments() {
        List<Payments> payments = new ArrayList<>();

        try {
            String query = " SELECT * FROM payments;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int payment_id = resultSet.getInt("payment_id");
                int amount_due = resultSet.getInt("amount_due");
                String payment_method = resultSet.getString("payment_method");
                String payment_date = resultSet.getString("payment_date");
                int repair_id = resultSet.getInt("repair_id");

                Payments payment = new Payments(payment_id, amount_due,
                        payment_method, payment_date, repair_id);


                payments.add(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payments;
    }

    public static boolean addPayment(Payments payments) {
        boolean isPaymentAdded = false;

        try {
            String query = "INSERT INTO payments (amount_due, payment_method, payment_date," +
                    " repair_id) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, payments.getAmount_due());
            statement.setString(2, payments.getPayment_method());
            statement.setString(3, payments.payment_date);
            statement.setInt(4, payments.getRepair_id());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                isPaymentAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isPaymentAdded;
    }

    public static boolean  updatePayment(Payments payments) {
        boolean isPaymentUpdated = false;

        try {
            String query = "UPDATE payments SET amount_due=?, payment_method=?," +
                    " payment_date=? WHERE payment_id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, payments.getAmount_due());
            statement.setString(2, payments.getPayment_method());
            statement.setString(3, payments.getPayment_date());
            statement.setInt(4, payments.getPayment_id());
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                isPaymentUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isPaymentUpdated;
    }



        public static boolean deletePayment(int paymentId) {
            boolean isPaymentDeleted = false;

            try {
                String query = "DELETE FROM customers WHERE customer_id=?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, paymentId);
                int rowsDeleted = statement.executeUpdate();

                if (rowsDeleted > 0) {
                    isPaymentDeleted = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return isPaymentDeleted;
    }
}