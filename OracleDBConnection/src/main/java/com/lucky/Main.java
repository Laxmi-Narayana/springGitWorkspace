package com.lucky;

import com.lucky.connect.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private static final String url = "jdbc:oracle:thin:@localhost:1521/lucky2000";
    private static final String uname = "lucky";
    private static final String pword = "2000";
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DBConnection dbConnection = new DBConnection(url,uname,pword);
        try {
            Connection con = dbConnection.connect();
            System.out.println("hello connected to db");
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End of world!...");
    }
}