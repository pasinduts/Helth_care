<%@page import="com.paf.controller.PatientController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.5.0.min.js"></script>
<script src="Components/patient.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Patient Management</h1>
				<form id="formPatient" name="formPatient">

					Patient Name: 
					<input id="Pname" name="pName" type="text" class="form-control form-control-sm"> 
					<br> 
					
					Gender: 
					<input id="Gender" name="gender" type="text" class="form-control form-control-sm"> 
					<br>
					
					Age: 
					<input id="Age" name="age" type="text" class="form-control form-control-sm"> 
					<br>
					 
					Blood group: 
					<input id="Blood_group" name="bg" type="text" class="form-control form-control-sm"> 
					<br>
					Contact: 
					<input id="Pcontact" name="contact" type="text" class="form-control form-control-sm"> 
					<br> 
					
					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary"> 
					<input type="hidden" id="hidPIDSave" name="hidPIDSave" value="">

				</form>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divPatientGrid">
					<%
						PatientController patient = new PatientController();
						out.print(patient.readPatient());
					%>
				</div>