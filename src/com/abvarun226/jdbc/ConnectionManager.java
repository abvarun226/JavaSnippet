package com.abvarun226.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by bharghav on 10/20/14.
 */
public class ConnectionManager {

    private static ConnectionManager instance = null;
    private static final String DBUSERNAME = "username";
    private static final String DBPASSWORD = "password";
    private static final String M_CONN_STRING = "jdbc:mysql://HOSTNAME/DBNAME";

    private static Connection conn = null;

    private ConnectionManager () {
    }

    public static ConnectionManager getInstance() {

        if(instance == null) {
            instance = new ConnectionManager();
        }
        return instance;

    }

    public boolean openConnection() {

        try {
            conn = DriverManager.getConnection(M_CONN_STRING, DBUSERNAME, DBPASSWORD);
            return true;
        } catch (SQLException e) {
            System.err.println("Unable to connect to database");
            return false;
        }

    }

    public Connection getConnection() {

        if(conn == null) {
            if(openConnection()) {
                System.out.println("Connection Established");
                return conn;
            } else {
                return null;
            }
        }
        return conn;

    }

    public void close() {

        try {
            if (conn != null) {
                conn.close();
                conn = null;
                System.out.println("Connection Closed");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

    }
}
