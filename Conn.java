/*
Connection Class to built the connection with the Mysql Database.
Register the driver
Load the Driver
Create Connection
Create Statement
Excute Query
Close Connection
*/
package bank.management.system1;

import java.sql.*;

 public  class Conn{
    Connection c;
    Statement s;
  public Conn()
   {
     try
     {
         //Register the Driver
         Class.forName("com.mysql.cj.jdbc.Driver");
         c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","abhi@$87#");
         s=c.createStatement();
     }
     catch(Exception e)
     {
         System.out.println(e);
     }
    }
  }
