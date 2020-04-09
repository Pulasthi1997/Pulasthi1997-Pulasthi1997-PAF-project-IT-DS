package model;
import java.sql.*;
public class Doctor
{ //A common method to connect to the DB
private Connection connect()
 {
 Connection con = null;
 try
 {
 Class.forName("com.mysql.jdbc.Driver");

 //Provide the correct details: DBServer/DBName, username, password
 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthmanagement", "root", "");
 }
 catch (Exception e)
 {e.printStackTrace();}
 return con;
 } 
public String insertItem(String dname, String dtype, String contact, String address,String email,String nic)
{
String output = "";
try
{
Connection con = connect();
if (con == null)
{return "Error while connecting to the database for inserting."; }
// create a prepared statement
String query = " insert into doctor (`Doctor_ID`,`D_Name`,`D_Type`,`D_Contact_Number`,`D_Address`,`D_Email`,`D_NIC)"
+ " values (?, ?, ?, ?,?,?,?)";
PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
preparedStmt.setInt(1, 0);
preparedStmt.setString(2, dname);
preparedStmt.setString(3, dtype);
//preparedStmt.setDouble(4, Double.parseDouble(price));
preparedStmt.setInt(4,Integer.parseInt(contact));
preparedStmt.setString(5, address);
preparedStmt.setString(6, email);
preparedStmt.setString(7, nic);


//execute the statement
preparedStmt.execute();
con.close();
output = "Inserted successfully created";
}
catch (Exception e)
{
output = "Error while inserting the item.";
System.err.println(e.getMessage());
}
return output;
} 
}