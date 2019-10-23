<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddPlacements" method="post" autocomplete="off" >
 
 <div class="container">
 			<h1 align="center">Add Placements</h1>
			<table style="with: 50%">
				<tr>
					<td>Placement Id</td>
					<td>:</td>
					<td><input type="number" name="placement_Id" required/></td>
				</tr>
				<tr>
					<td>Company Name</td>
					<td>:</td>
					<td><input type="text" name="company_name" required/></td>
				</tr>
				<tr>
					<td>Date</td>
					<td>:</td>
					<td><input type="date" name="date" required/></td>
				</tr>
				<tr>
					<td>Percentage</td>
					<td>:</td>
					<td><input type="number" name="percentage" required/></td>
				</tr>
				<tr>
				<td></td>
				<td></td>
				<td><input type="submit" class="button" value="Submit" onclick="Successful.html" ></td>
				</tr>
				</div> 
				</form>
</body>
</html>