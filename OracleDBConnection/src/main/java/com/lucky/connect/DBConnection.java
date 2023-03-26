package com.lucky.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String url;
    private String uname;
    private String pword;

    public DBConnection() {
    }

    public DBConnection(String url, String uname, String pword) {
        this.url = url;
        this.uname = uname;
        this.pword = pword;
    }

    public Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(url,uname,pword);
        return connection;
    }
}