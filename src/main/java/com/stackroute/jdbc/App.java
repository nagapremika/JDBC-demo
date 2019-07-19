package com.stackroute.jdbc;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        simpleJdbcDemo.getEmployeeDetails(); //get employee details from table
        simpleJdbcDemo.getEmployeeDetailsInReverse();//Displays the table in reverse order
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();  //Displays from second row in reverse order
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender(); //Returns name and gender from every row


        ResultSetMetadataDemo resultSetMetadataDemo = new ResultSetMetadataDemo();
        resultSetMetadataDemo.getMetaData();    //Returns number of columns and Table name
        DatabaseMetadataDemo databaseMetadataDemo = new DatabaseMetadataDemo();
        databaseMetadataDemo.executeDatabaseMetadataDemo(); //Returns metadata of database
        JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
        jdbcBatchDemo.executeJdbcBatch();   //Inserts a new batch
        RowSetDemo rowSetDemo = new RowSetDemo();
        rowSetDemo.executeRowSetDemo(); //calls RowSetDemo method
        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.executeJdbcTransactionDemo();   //Checks a transaction to commit or rollback
    }
}
