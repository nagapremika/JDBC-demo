package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void getMetaData()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //loading a driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//Creating connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customers", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet=statement.executeQuery("select * from customers");
                    )
        {
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            System.out.println(resultSetMetaData.getColumnCount()); //gives number of columns
            System.out.println(resultSetMetaData.getTableName(1));

            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
