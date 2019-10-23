<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- css external style sheets -->
<link rel="stylesheet" href="css/animation.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">

<!-- bootstrap href -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<!-- jQuery href -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- bootstrap responsive view -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Add Faculty</title>
</head>
<body>
 
 
 <div class="container">
 
 <div class="titles">
<div class="row">
<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
 <h1 class="fadeIn first">ADD FACULTY</h1>
</div>
</div>
</div>
 
 <div class="wrapper fadeInDown">
            <div id="formContent">
 
 <form action="AddFaculty" method="post" autocomplete="off" >
 	
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
				<td><input type="submit" class="button" value="Submit" onclick="alert('Added Successfully!');" ></td>
				
			</tr>
			
	
				</table>
				
					    <!-- Sign Up as a New User -->
                 <div id="formFooter">
                      <a href="AdminMainMenu.html" class="fadeIn third">Go Back to Home Page</a>
                </div>
				
				</form>
				</div>
				</div>
				</div>
				
</body>
</html>