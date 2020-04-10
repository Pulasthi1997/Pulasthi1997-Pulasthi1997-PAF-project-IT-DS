package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hospital {
     //A common method to connect to the DB
		private Connection connect()
		 {
		 Connection con = null;
		 try
		 {
		 Class.forName("com.mysql.jdbc.Driver");
         //Connection//good
		 //Provide the correct details: DBServer/DBName, username, password
		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf_project?useTimezone=true&serverTimezone=UTC", "root", "");
		 }
		 catch (Exception e)
		 {e.printStackTrace();}
		 return con;
		 } 
		
		public String insertHospital(String hName, String contactNo, String address, String email) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for inserting.";
				}
				// create a prepared statement
				String query = " insert into hospital(`H_ID`,`H_name`,`H_contactNumber`,`H_address`,`H_email`)"
						+ " values (?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, hName);
				preparedStmt.setString(3, contactNo);
				preparedStmt.setString(4, address);
				preparedStmt.setString(5, email);

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Inserted successfully";
			} catch (Exception e) {
				output = "Error while inserting the Hospitals.";
				System.err.println(e.getMessage());
			}
			return output;
		}

		public String readHospital() {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}
				// Prepare the html table to be displayed
				output = "<table border=\"1\">"
						+ "<th>Hospital Name</th"
						+ "><th>Contatct No</th>"
						+ "<th>Address</th>"
						+ "<th>E-mail</th>"
						+ "<th>Update</th>"
						+ "<th>Remove</th></tr>";
				String query = "select * from hospital";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// iterate through the rows in the result set
				while (rs.next()) {
					String H_ID = Integer.toString(rs.getInt("H_ID"));
					String H_name = rs.getString("H_name");
					String H_contactNumber = rs.getString("H_contactNumber");
					String H_address = rs.getString("H_address");
					String H_email = rs.getString("H_email");
					
					output += "<tr><td><input id=\"hidHospitalIDUpdate\"name=\"hidHospitalIDUpdate\"type=\"hidden\" value=\"" + H_ID +  "</td>";
					// Add into the html table
					output += "<tr><td>" + H_name + "</td>";
					output += "<td>" + H_contactNumber + "</td>";
					output += "<td>" + H_address + "</td>";
					output += "<td>" + H_email + "</td>";
					// buttons
					output += "<tr><td><input  name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"
							+ "<td><form method=\"post\" action=\"hospital.jsp\">"
							+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
							+ "<input name=\"H_ID\" type=\"hidden\" value=\"" + H_ID + "\">" + "</form></td></tr>";
				}
				con.close();
				// Complete the html table
				output += "</table>";
			} catch (Exception e) {
				output = "Error while reading the Hospitals.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		public String updateHopital(String ID, String hName, String contactNo, String address, String email) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				//update
				// create a prepared statement
				String query = "UPDATE hospital SET H_name=?,H_contactNumber=?,H_address=?,H_email=? WHERE H_ID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setString(1, hName);
				preparedStmt.setString(2, contactNo);
				preparedStmt.setString(3, address);
				preparedStmt.setString(4, email);
				preparedStmt.setInt(5, Integer.parseInt(ID));
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully";
			} catch (Exception e) {
				output = "Error while updating the Hospital.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		public String deleteHospital(String H_ID) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from hospital where H_ID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(H_ID));
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = " Hospital Deleted successfully";
			} catch (Exception e) {
				output = "Error while deleting the Hospital.";
				System.err.println(e.getMessage());
			}
			return output;
		}		
}