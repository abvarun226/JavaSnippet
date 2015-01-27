package com.abvarun226.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by bharghav on 10/20/14.
 */

public class databaseMetadata {

    public static void main(String[] args) throws SQLException {

        Connection conn = ConnectionManager.getInstance().getConnection();

        ResultSet rsTable = null;
        ResultSet rsColumn = null;

        ArrayList<String> tableList = new ArrayList<>();

        try {
            DatabaseMetaData metadata = conn.getMetaData();
            String[] tableType = {"TABLE"};
            rsTable = metadata.getTables(null, "%","%", tableType);

            while(rsTable.next()) {
                tableList.add(rsTable.getString("TABLE_NAME"));
            }

            for(String tableName : tableList) {
                rsColumn = metadata.getColumns(null, "%", tableName, "%");
                System.out.println("TableName : " + tableName);
                System.out.println("----------------");

                while(rsColumn.next()) {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(rsColumn.getString("COLUMN_NAME"));
                    buffer.append(" : ");
                    buffer.append(rsColumn.getString("TYPE_NAME"));
                    System.out.println(buffer);
                }
                System.out.println("");
            }

        } catch(SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if(rsColumn != null) rsColumn.close();
            if(rsTable != null) rsTable.close();
        }

        ConnectionManager.getInstance().close();
    }
}
