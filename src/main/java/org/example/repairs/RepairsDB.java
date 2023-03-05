package org.example.repairs;

import org.example.DataBase.DBmanager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepairsDB extends DBmanager {

    public static List<Repairs> GetRepairs() {
        List<Repairs> repairs = new ArrayList<>();

        try {
            String query = " SELECT * FROM repairs;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int repair_id = resultSet.getInt("repair_id");
                int repair_cost = resultSet.getInt("repair_cost");
                String repair_start = resultSet.getString("repair_start");
                String repair_finished = resultSet.getString("repair_finished");
                int customer_id = resultSet.getInt("customer_id");
                int mobile_id = resultSet.getInt("mobile_id");

                Repairs repair = new Repairs(repair_id, repair_cost,
                        repair_start, repair_finished,customer_id,mobile_id);

                repairs.add(repair);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return repairs;
    }

    public static boolean addRepair(Repairs repairs) {
        boolean isRepairAdded = false;

        try {
            String query = "INSERT INTO repairs (repair_cost,repair_start,repair_finished,customer_id," +
                    " mobile_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, repairs.getRepair_cost());
            statement.setString(2, repairs.getRepair_start());
            statement.setString(3, repairs.getRepair_finished());
            statement.setInt(4, repairs.getCustomer_id());
            statement.setInt(5, repairs.getMobile_id());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                isRepairAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRepairAdded;
    }



    public static boolean  updateRepair(Repairs repairs) {
        boolean isRepairUpdated = false;

        try {
            String query = "UPDATE repairs SET repair_cost=?, repair_start=?,repair_finished=?,customer_id=?," +
                    " mobile_id=? WHERE repair_id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, repairs.getRepair_cost());
            statement.setString(2, repairs.getRepair_start());
            statement.setString(3, repairs.getRepair_finished());
            statement.setInt(3, repairs.getCustomer_id());
            statement.setInt(3, repairs.getMobile_id());
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                isRepairUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRepairUpdated;
    }

    public static boolean deleteRepair(int repairId) {
        boolean isRepairDeleted = false;

        try {
            String query = "DELETE FROM repairs WHERE repair_id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, repairId);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                isRepairDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRepairDeleted;
    }


}
