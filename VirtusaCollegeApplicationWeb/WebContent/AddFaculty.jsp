<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="AddFaculty" method="post" autocomplete="off" >
 
 <div class="container">
 			<h1 align="center" colour = "blue">Add Faculty Details</h1>
			<table style="with: 50%">
				<tr>
					<td>Faculty Id</td>
					<td>:</td>
					<td><input type="number" name="faculty_Id" required/></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td>:</td>
					<td><input type="text" name="first_name" required/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td>:</td>
					<td><input type="text" name="last_name" required/></td>
				</tr>
				<tr>
					<td>DOB</td>
					<td>:</td>
					<td><input type="date" name="dob" required/></td>
				</tr>
				<tr>
					<td>EmailId</td>
					<td>:</td>
					<td><input type="text" name="email_id" required/></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td>:</td>
					<td><input type="number" name="phone_number" required/></td>
				</tr>
				<tr>
					<td>Department Name</td>
					<td>:</td>
					<td><input type="text" name="department_name" required/></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td>:</td>
					<td><input type="number" name="salary" required/></td>
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