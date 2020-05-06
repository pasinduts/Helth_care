package com.paf.controller;

//import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.paf.model.PatientModel;
import com.paf.util.DBConnection;
import java.util.List;

public class PatientController {

	private static Connection connection;
	private static PreparedStatement ps;
	private static ResultSet rs;

//******************************************DATA INSERT*************************************************************

	public String AddPatient(PatientModel Patient) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for inserting.";
			}

			ps = connection.prepareStatement(
					"INSERT INTO  Patient(PID,Pname,Gender,Age,Blood_group,Pcontact) " + "	VALUES (?,?,?,?,?,?)");

			ps.setInt(1, 0);
			ps.setString(2, Patient.getPname());
			ps.setString(3, Patient.getGender());
			ps.setInt(4, Patient.getAge());
			ps.setString(5, Patient.getBlood_group());
			ps.setString(6, Patient.getPcontact());

			ps.execute();
			connection.close();
			output = "Inserted successfully";

			String newPatient = readPatient();
			output = "{\"status\":\"success\", \"data\": \"" + newPatient + "\"}";

		}
//		 catch (Exception e)
//		 {
//		 output = "Error while inserting the patient.";
//		 System.err.println(e.getMessage());
//		 }
		catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the Patient.\"}";
			System.err.println(e.getMessage());
		}

		return output;

	}

//******************************************Read DATA*************************************************************

	public String readPatient() {

		String output = "";
		try {
			connection = DBConnection.getConnection();

			if (connection == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Patient Name</th><th>Gender</th> <th>Age</th><th>Blood Group</th> <th>Contact</th> <th>Update</th><th>Remove</th></tr>";
			String query = "select * from patient";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String PID = Integer.toString(rs.getInt("PID"));
				String Pname = rs.getString("Pname");
				String Gender = rs.getString("Gender");
				String Age = Integer.toString(rs.getInt("Age"));
				String Blood_group = rs.getString("Blood_group");
				String Pcontact = rs.getString("Pcontact");

				// Add into the html table
				output += "<tr><td><input id='hidPIDUpdate' name='hidPIDUpdate' type='hidden' value='" + PID + "'>"
						+ Pname + "</td>";
				output += "<td>" + Gender + "</td>";
				output += "<td>" + Age + "</td>";
				output += "<td>" + Blood_group + "</td>";
				output += "<td>" + Pcontact + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td> <td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-PID='"	+ PID + "'>" + "</td></tr>";
			}
			connection.close();
			// Complete the html table
			output += "</table>";

			connection.close();

		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the Patient.\"}";
			System.err.println(e.getMessage());
		}

		return output;
	}

//******************************************UPDATE DATA*************************************************************

//	public String updatePatient(PatientModel Patient) {
//		String output = "";
//		try {
//			connection = DBConnection.getConnection();
//			if (connection == null) {
//				return "Error while connecting to the database for updating.";
//			}
//			// create a prepared statement
//			ps = connection.prepareStatement(
//					"UPDATE Patient SET Pname=?,Gender=?,Age=?,Blood_group=?,Pcontact=? WHERE PID=?");
//
//			// binding values
//			ps.setInt(1, 0);
//			ps.setString(2, Patient.getPname());
//			ps.setString(3, Patient.getGender());
//			ps.setInt(4, Patient.getAge());
//			ps.setString(5, Patient.getBlood_group());
//			ps.setString(6, Patient.getPcontact());
//			
//			// execute the statement
//			ps.execute();
//			connection.close();
//			output = "Updated successfully";
//		} catch (Exception e) {
//			output = "Error while updating the Patient.";
//			System.err.println(e.getMessage());
//		}
//		return output;
//	}

	public String updatePatient(PatientModel patient) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			ps = connection
					.prepareStatement("UPDATE Patient SET Pname=?,Gender=?,Age=?,Blood_group=?,Pcontact=? WHERE PID=?");

			// binding values
			ps.setString(1, patient.getPname());
			ps.setString(2, patient.getGender());
			ps.setInt(3, patient.getAge());
			ps.setString(4, patient.getBlood_group());
			ps.setString(5, patient.getPcontact());
			ps.setInt(6, patient.getPID());
			// execute the statement
			ps.execute();
			connection.close();
//			output = "Updated successfully";

			String newPatient = readPatient();
			output = "{\"status\":\"success\", \"data\": \"" + newPatient + "\"}";

		}catch (Exception e)
		 {
			 output = "{\"status\":\"error\", \"data\":\"Error while updating the Patient.\"}";
			 System.err.println(e.getMessage());
			 } 

		return output;
	}

//******************************************DELETE Patient*************************************************************

	public String deletePatient(String PID) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			connection = DBConnection.getConnection();
			ps = connection.prepareStatement("delete from Patient where PID=?");
			// binding values
			ps.setInt(1, Integer.parseInt(PID));
			// execute the statement
			ps.execute();
			connection.close();

			String newPatient = readPatient();
			output = "{\"status\":\"success\", \"data\": \"" + newPatient + "\"}";

		} catch (Exception e) {
			output = "Error while deleting the patient. -" + e.getMessage();
			System.err.println(e.getMessage());
		}
		return output;
	}
}
