package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import database.dbconnect;

public class Hospital {
	// A common method to connect to the DB
	dbconnect obj = new dbconnect();

	public String insertHospital(String hName, String contactNo, String address, String email) {

		String output = "";
		try {
			Connection con = obj.connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			//Insert Hospital
			// create a prepared statement
			String query = " insert into hospital(`H_name`,`H_contactNumber`,`H_address`,`H_email`)"
					+ " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, hName);
			preparedStmt.setString(2, contactNo);
			preparedStmt.setString(3, address);
			preparedStmt.setString(4, email);
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newHospitals = readHospital();
			output = "{\"status\":\"success\", \"data\": \"" +newHospitals+ "\"}";
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the Hospital.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readHospital() {
		String output = "";
		try {
			Connection con = obj.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			//retriew Hospital details
			// Prepare the html table to be displayed
			//output = "<table border=\'1\">" + "<th>Hospital Name</th" + "><th>Contatct No</th>" + "<th>Address</th>"
					//+ "<th>E-mail</th>" + "<th>Update</th>" + "<th>Remove</th></tr>";
			
			output = "<table border='1'><tr><th>Hospital Name</th><th>Contact No</th><th>"
					+ "Address</th><th>Email</th><th>Update</th><th>Remove</th></tr>";
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
				
				//Replacing spaces in Hospital name
				H_name=H_name.replace('+', ' ');
				//Replacing spaces,commas and slashes in Hospital address
				H_address=H_address.replace('+', ' ');
				H_address=H_address.replaceAll("%2C",",");
				H_address=H_address.replaceAll("%2F","/");
				//Replacing @ in Hospital email
				H_email=H_email.replaceAll("%40","@");

				// Add into the html table
				output += "<tr><td><input id=\'hidHospitalIDUpdate\'name=\'hidHospitalIDUpdate\'type=\'hidden\' value=\'"
						+ H_ID + "\'>" + H_name + "</td>";
				output += "<td>" + H_contactNumber + "</td>";
				output += "<td>" + H_address + "</td>";
				output += "<td>" + H_email + "</td>";

				// buttons
				
				
				output += "<td><input name='btnUpdate'type='button' "
						+ "value='Update'class='btnUpdate btn btn-success'></td>"
						+ "<td><input name='btnRemove'type='button' "
						+ "value='Remove'class='btnRemove btn btn-danger'data-hospitalid='"+ H_ID + "'>" + "</td></tr>";
				
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
			Connection con = obj.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// update Hospital
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
			String newHospitals = readHospital();
			output = "{\"status\":\"success\", \"data\": \"" +newHospitals+ "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the Hospitals.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteHospital(String H_ID) {
		String output = "";
		try {
			Connection con = obj.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			//delete  Hospital
			// create a prepared statement
			String query = "delete from hospital where H_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(H_ID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newHospitals = readHospital();
			output = "{\"status\":\"success\", \"data\": \"" +newHospitals+ "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the Hospitals.\"}";
			System.err.println(e.toString());
		}
		return output;
	}

}