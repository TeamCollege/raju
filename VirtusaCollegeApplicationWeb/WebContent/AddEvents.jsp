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
<title>Add Events</title>
</head>
<body>
     
 
 <div class="container">
 
 <div class="titles">
<div class="row">
<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
 <h1 class="fadeIn first">ADD EVENTS</h1>
</div>
</div>
</div>
 
  <div class="wrapper fadeInDown">
            <div id="formContent">
            
            <form action="admin" method="post" autocomplete="off" >
 			
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