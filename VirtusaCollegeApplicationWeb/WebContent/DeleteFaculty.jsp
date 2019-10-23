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

<title>Delete Faculty</title>
</head>
<body>
 
 
 <div class="container">
 
 <div class="titles">
<div class="row">
<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
 <h1 class="fadeIn first">DELETE FACULTY</h1>
</div>
</div>
</div>

 <div class="wrapper fadeInDown">
            <div id="formContent">
            
            
 
 <form action="DeleteFaculty" method="post" autocomplete="off" >
 		
			<table style="with: 50%">
				<tr>
					<td>Faculty Id</td>
					<td>:</td>
					<td><input type="number" name="faculty_Id" required/></td>
				</tr>
				<tr>
				<td></td>
				<td></td>
				<td><input type="submit" class="button" value="Submit" onclick="alert('Deleted Successfully!');"></td>
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