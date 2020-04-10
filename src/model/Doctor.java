package model;

import java.sql.*;

public class Doctor { // A common method to connect to the DB

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/paf_project?useTimezone=true&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertDoctors(String dname, String dtype, String contact, String address, String email, String nic) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting..";
			}
// create a prepared statement
			String query = " insert into doctor (`D_Name`,`D_Type`,`D_Contact_Number`,`D_Address`,`D_Email`,`D_NIC`)"
					+ " values ( ?, ?, ?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
			//preparedStmt.setInt(1, 0);
			preparedStmt.setString(1, dname);
			preparedStmt.setString(2, dtype);
//preparedStmt.setDouble(4, Double.parseDouble(price));
			preparedStmt.setInt(3, Integer.parseInt(contact));
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, email);
			preparedStmt.setString(6, nic);

//execute the statement
//execute the statement	
//execute the statement	

			preparedStmt.execute();
			con.close();
			output = "Inserted successfully created ";
		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readDoctors() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Doctor Name</th><th>Doctor specification</th><th>"
					+ "Contact Number</th><th>Doctor Address</th><th>Doctor Email </th><th>Doctor NIC</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from doctor";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
// iterate through the rows in the result set
			while (rs.next()) {
				String Doctor_ID = Integer.toString(rs.getInt("Doctor_ID"));
				String D_Name = rs.getString("D_Name");
				String D_Type = rs.getString("D_Type");
//String itemPrice = Double.toString(rs.getDouble("itemPrice"));
				String D_Contact_Number = Integer.toString(rs.getInt("D_Contact_Number"));
				String D_Address = rs.getString("D_Address");
				String D_Email = rs.getString("D_Email");
				String D_NIC = rs.getString("D_NIC");

				//Add into the html table
				output += "<tr><td><input id=\"hidDoctorIDUpdate\"name=\"hidDoctorIDUpdate\"type=\"hidden\" value=\"" + Doctor_ID + "\">"
                                               + D_Name + "</td>";
				output += "<td>" + D_Type + "</td>";
				output += "<td>" + D_Contact_Number + "</td>";
				output += "<td>" + D_Address + "</td>";
				output += "<td>" + D_Email + "</td>";
				output += "<td>" + D_NIC + "</td>";
// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"Doctor_Insert.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
						+ "<input name=\"hidDoctorIDDelete\" type=\"hidden\" value=\"" + Doctor_ID + "\">" + "</form></td></tr>";
			}
			con.close();
//Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items...";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateDoctors(String ID, String dname, String dtype, String contact, String address, String email,
			String nic) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
// create a prepared statement
			String query = "UPDATE doctor SET D_Name=?,D_Type=?,D_Contact_Number=?,D_Address=?,D_Email=?,D_NIC=? WHERE Doctor_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
			preparedStmt.setString(1, dname);
			preparedStmt.setString(2, dtype);
//preparedStmt.setDouble(3, Double.parseDouble(price));
			preparedStmt.setInt(3, Integer.parseInt(contact));
			preparedStmt.setString(4, address);
//preparedStmt.setInt(5, Integer.parseInt(ID));
			preparedStmt.setString(5, email);
			preparedStmt.setString(6, nic);
			preparedStmt.setInt(7, Integer.parseInt(ID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	public String deleteDoctor(String Doctor_ID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
// create a prepared statement
			String query = "delete from doctor where Doctor_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
			preparedStmt.setInt(1, Integer.parseInt(Doctor_ID));
// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}