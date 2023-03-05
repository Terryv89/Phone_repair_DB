package org.example.mobiles;

import org.example.DataBase.DBmanager;
import org.example.customers.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MobilesDB extends DBmanager {

    public static List<Mobiles> GetMobiles() {
        List<Mobiles> mobiles = new ArrayList<>();

        try {
            String query = " SELECT * FROM mobiles;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int mobiles_id = resultSet.getInt("mobile_id");
                String brand_name = resultSet.getString("brand_name");
                String model_name = resultSet.getString("model_name");

                Mobiles mobile = new Mobiles(mobiles_id, brand_name,
                        model_name);

                mobiles.add(mobile);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return mobiles;
    }

    public static boolean addMobile(Mobiles mobiles) {
        boolean isMobileAdded = false;

        try {
            String query = "INSERT INTO mobiles (brand_name, model_name) " +
                            "VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, mobiles.getBrand_name());
            statement.setString(2, mobiles.getModel_name());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                isMobileAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isMobileAdded;
    }

    public static boolean  updateMobile(Mobiles mobiles) {
        boolean isMobileUpdated = false;

        try {
            String query = "UPDATE mobiles SET brand_name=?, model_name=? " +
                            "WHERE mobile_id=?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, mobiles.getBrand_name());
            statement.setString(2, mobiles.getModel_name());
            statement.setInt(3, mobiles.getMobile_id());
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                isMobileUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isMobileUpdated;
    }

    public static boolean deleteMobile(int mobileId) {
        boolean isMobileDeleted = false;

        try {
            String query = "DELETE FROM mobiles WHERE mobile_id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, mobileId);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                isMobileDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isMobileDeleted;
    }
}