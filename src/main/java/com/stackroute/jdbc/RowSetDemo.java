package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowSetDemo {
public void executeRowSetDemo() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");


    try {
        //Creating objects for the JdbcRowSetImplementation class
        JdbcRowSetImpl jrs = new JdbcRowSetImpl();
        //Setting the connection with the database
        jrs.setUrl("jdbc:mysql://localhost:3306/employeedb");
        //Setting the username and password
        jrs.setUsername("root");
        jrs.setPassword("Root@123");
        //Giving the query to execute
        jrs.setCommand("SELECT * FROM Employee where Name=?");
        //Setting the name of which it have to return
        jrs.setString(1, "Sahithi");
        //Calling the execute method
        jrs.execute();
        //Printing the values of the specified name
        while (jrs.next())
            System.out.println("Id: " + jrs.getInt(1) + " Name: " + jrs.getString(2));
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

}
}
