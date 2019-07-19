package com.stackroute.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetadataDemo {
    public void executeDatabaseMetadataDemo()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Customers","root","Root@123");) {
            DatabaseMetaData databaseMetaData = con.getMetaData();

        System.out.println("Driver Name: "+databaseMetaData.getDriverName());   //Driver Name
        System.out.println("Driver Version: "+databaseMetaData.getDriverVersion()); //Driver Version
        System.out.println("UserName: "+databaseMetaData.getUserName());    //Username
        System.out.println("Database Product Name: "+databaseMetaData.getDatabaseProductName());    //Database Product name
        System.out.println("Database Product Version: "+databaseMetaData.getDatabaseProductVersion());  //Version
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
