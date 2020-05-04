<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Hospital" %>
    <%@ page import="com.HospitalAPI" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital_Insert</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./Components/Hospital.js"></script>
  <style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 90%;
  margin-left: auto;
  margin-right: auto;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
.card{
	padding: 20px;
	border: 1px solid black;
	border-radius: 10px;
	margin-bottom: 20px;
	font-size: 15px;
	margin-top: 15px;
}
#btnSave{
	margin-top: 15px;
	font-size: px;
	width: 100%;
}
.alert{
	width: 80%;
	margin-left: auto;
	margin-right: auto;
	padding: 15px;
	text-align: center;
}

  </style>
</head>
<body>
	<div class="jumbotron text-center" style="padding: 10px;;">
		<h1>Hospital Registration and Update Form</h1>
	
	</div>
	<div class="container">
		<div class="row"><div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="card">
	<form  id="formHospital" name="formHospital" method="post" action="Hospital_Config.jsp">
		Hospital Name: 
		<input id="H_name" name="H_name" type="text"
			class="form-control form-control-sm" required> <br>
	    Contact No:
	     <input id="H_contactNumber" name="H_contactNumber" type="text" placeholder="0xxxxxxxxx" maxlength="10"
			 pattern="^\d{10}$" class="form-control form-control-sm"required > <br> 
		Address: 
		<input id="H_address" name="H_address" type="text"
			class="form-control form-control-sm" required> <br> 
		E-mail:
		 <input id="H_email" name="H_email" type="text"  
			class="form-control form-control-sm" required> <br> 
		<input id="btnSave" name="btnSave" type="button" value="Save" 
			class="btn btn-primary"  > 
		<input type="hidden" id="hidHospitalIDSave" name="hidHospitalIDSave" value="">
	</form>
	</div>
</div>
</div>
</div>

	
	<div id="alertSuccess" class="alert alert-success">
	
			
		
		</div>
		<div id="alertError" class="alert alert-danger"></div>
		
     <div id="divItemsGrid">
	<% 
	      Hospital h1= new Hospital();
		out.print(h1.readHospital());
	     %>
	   </div>
	  
	  
		
</body>
</html>