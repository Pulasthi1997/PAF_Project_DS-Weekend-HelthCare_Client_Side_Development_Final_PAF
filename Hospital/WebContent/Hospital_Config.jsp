<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Hospital" %>
<%@ page import="com.HospitalAPI" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Hospital_Insert</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./Components/Hospital.js"></script>
	<style>
		body{
		
		}
		.img{
			height: auto;
			padding: 50px;
			background-image: url('pics/main.jpeg');
			filter: brightness(50%);
			background-size: cover;
			background-position: bottom;
		}
		.img h1{
			color: white;
			font-size: 100px;
			margin-top: 5%;
		}
		table {
			font-family: arial, sans-serif;
			border-collapse: collapse;
			width: 90%;
			margin-left: auto;
			margin-right: auto;
		}

		td,
		th {
			border: 1px solid #dddddd;
			text-align: left;
			padding: 8px;
		}

		tr:nth-child(even) {
			background-color: #dddddd;
		}

		.card {
			padding: 30px;
			border: 1px solid black;
			border-radius: 10px;
			margin-bottom: 20px;
			font-size: 15px;
			margin-top: 15px;
			background-image: url('pics/fJc5OX.jpg');
			background-size: cover;
			color: white;
			font-weight: 900;
			background-repeat: no-repeat ;

		

		}

		#btnSave {
			margin-top: 15px;
			font-size: 20px;
			padding: 10px;
			width: 100%;
		}

		.alert {
			width: 80%;
			margin-left: auto;
			margin-right: auto;
			padding: 15px;
			text-align: center;
		}
		.form-control{
			padding: 25px;
		
			border: 1px solid gray;
		}
		::placeholder{
			color: black;
		}
		.footer {

   left: 0;
   bottom: 0;
   width: 100%;
   padding: 50px;;
   background-color: black;
   color: white;
   font-size: 18px;
   text-align: center;
   text-align: left;
}
 
.fa{
	margin-top: 50px;;
	margin-left: 20px;
	font-size: 25px;
	color: white;
}
.fa:hover{
	color: red;
}
.footer a{
	text-decoration: none;
}
td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
	font-weight:bold;
}


th {
	border: 1px solid #dddddd;	
	background-color: #D5DBDB;
	text-align: left;
	padding: 10px;
}
	</style>
</head>

<body style="background-image: url('pics/hospital-room-with-glass-window-blog.jpg');">
	<div class="jumbotron text-center img" style="padding: 10px;;">
		<h1>Hospital Management</h1>

	</div>
	
	<div class="container"  >
		<div class="row" >
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="card">
					<form id="formHospital" name="formHospital" method="post" action="Hospital_Config.jsp">
					Hospital Name
						<input id="H_name" name="H_name" type="text" class="form-control form-control-sm" placeholder="name" required> <br>
					Contact No
						<input id="H_contactNumber" name="H_contactNumber" type="text" placeholder="123456789"
							maxlength="10" pattern="^\d{10}$" class="form-control form-control-sm" required> <br>
					Address
						<input id="H_address" name="H_address" type="text" placeholder="address" class="form-control form-control-sm"
							required> <br>
					E-mail
						<input id="H_email" name="H_email" type="text" placeholder="abc@gmail.com"  class="form-control form-control-sm" required>
						<br>
						<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
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

<div class="footer">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<br><br>
				Email : pulsathikaru@gmail.com <br><br>
				Phone : 0766980698
			</div>
			<div class="col-md-4">
					<div class="social">
						<a href="https://www.facebook.com/" class="fa fa-facebook"></a>
						<a href="https://twitter.com/explore" class="fa fa-twitter"></a>
						<a href="https://www.linkedin.com/" class="fa fa-linkedin"></a>
						<a href="https://www.instagram.com/" class="fa fa-instagram"></a>
						<a href="https://www.youtube.com/" class="fa fa-youtube"></a>
					</div>
			</div>
			<div class="col-md-4">
				<br><br>
				Address : NO 35<br> Temple Street<br> Colombo <br>Sri Lanka  

			</div>
		</div>
	</div>
</div>
</body>

</html>