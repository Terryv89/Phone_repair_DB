package org.example.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DBmanager {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:8889/phone_repair_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";
    protected static Connection conn;

    public boolean isConnected = false;

    public DBmanager(){
        try{

            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            isConnected = (conn != null);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
