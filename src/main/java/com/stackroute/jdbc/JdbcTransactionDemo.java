package com.stackroute.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcTransactionDemo {

    public void executeJdbcTransactionDemo()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id");
        int id=scanner.nextInt();
        System.out.println("Enter name");
        String name=scanner.next();
        System.out.println("Enter age");
        int age=scanner.nextInt();
        System.out.println("Enter gender");
        String gender=scanner.next();
        String query="insert into customers values("+id+","+name+","+age+","+gender+")";    //query having insertion
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //Loading class
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//Creating connection and statement object
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customers", "root", "Root@123");
             PreparedStatement preparedStatement=connection.prepareStatement(query);
             )
        {
            connection.setAutoCommit(false);    //autocommit is set to false
            try {
                if (name.length() > 20) {
                    throw new Exception();      //length of name less than 20 throws exception
                }
                else{
                    connection.commit();
                    System.out.println("Transaction commited");     //Transaction is commited

                }

            }
            catch (Exception e)
            {
                connection.rollback();
                System.out.println("Transaction Rollbacked");   //Catch rollbacks the transaction
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
