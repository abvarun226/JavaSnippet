package com.abvarun226.jdbc;

import java.sql.*;

/**
 * Created by bharghav on 10/19/14.
 */

public class mysqlConnect {
    private static final String DBUSERNAME = "username";
    private static final String DBPASSWORD = "password";
    private static final String M_CONN_STRING = "jdbc:mysql://HOSTNAME/DBNAME";
    private static final String SQL = "select * from GomezData limit ?";

    public static void main(String[] args) throws SQLException {

        double test1 = 1155.37;
        //double test2 = Double.parseDouble(test1);

        System.out.println("My double : " + test1);
        ResultSet rs = null;
        int limit;
        try {
            limit = InputHelper.getInputInteger("Enter the limit : ");
        } catch (NumberFormatException e) {
            System.err.println("Error : " + e.getMessage());
            return;
        }

        try (
                Connection conn = DriverManager.getConnection(M_CONN_STRING, DBUSERNAME, DBPASSWORD);
                //Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                //ResultSet rs = stmt.executeQuery("select * from GomezData limit 10");
                PreparedStatement stmt = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ) {
            stmt.setInt(1, limit);
            rs = stmt.executeQuery();
            System.out.println("Connected to Database");
            rs.last();
            int numRows = rs.getRow();
            rs.beforeFirst();
            System.out.println("Number of rows : " + numRows);

            int i = 1;
            while(rs.next()) {
                //String testTime = rs.getString("testTime");
                //String testName = rs.getString("testName");
                //int responseTime = rs.getInt("responseTime");

                String testTime = rs.getObject("testTime", String.class);
                String testName = rs.getObject("testName", String.class);
                int responseTime = rs.getObject("responseTime", Integer.class);

                StringBuffer buffer = new StringBuffer();
                buffer.append("Test Time : " + testTime + " | ");
                buffer.append("Test name : " + testName + " | ");
                buffer.append("Response Time : " + responseTime);
                System.out.println(buffer);
            }


        } catch (SQLException e) {
            System.out.println("Message : " + e.getMessage());
            System.out.println("Error Code : " + e.getErrorCode());
            System.out.println("SQL State : " + e.getSQLState());
        } finally {
            if(rs != null) {
                rs.close();
            }
        }

    }

}
