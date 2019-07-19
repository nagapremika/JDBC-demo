package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {
    public void executeJdbcBatch()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//Loads Driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customers", "root", "Root@123");
             Statement statement = connection.createStatement();        )   //Creates connection and statement object
        {
            statement.addBatch("insert into customers values(3,sahithi,20,female)");    //Adds a batch to the table
            System.out.println("Batch added");
        }




         catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
