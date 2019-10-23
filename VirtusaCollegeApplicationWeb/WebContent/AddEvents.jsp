<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- css external style sheets -->
<link rel="stylesheet" href="css/animation.css" text="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">

<!-- bootstrap href -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<!-- jQuery href -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- bootstrap responsive view -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
</head>
<body>
     <form action="admin" method="post" autocomplete="off" >
 
 <div class="container">
 			<h1 align="center" colour = "blue">Add Events</h1>
			<table style="with: 50%">
				<tr>
					<td>Event Id</td>
					<td>:</td>
					<td><input type="number" name="event_Id" required/></td>
				</tr>
				<tr>
					<td>Event Name</td>
					<td>:</td>
					<td><input type="text" name="event_name" required/></td>
				</tr>
				<tr>
					<td>Event date</td>
					<td>:</td>
					<td><input type="date" name="event_date" required/></td>
				</tr>
				<tr>
					<td>Event Location</td>
					<td>:</td>
					<td><input type="text" name="location" required/></td>
				</tr>
				<tr>
				<td><input type="submit" class="button" value="Submit" ></td>
				</tr>
				<td><input type ="submit" class="button" value ="Back"></td>
				<a href="AdminMainMenu.html" class="fadeIn sixth">Back</a>
				</div> 
				</form>
</body>
</html>