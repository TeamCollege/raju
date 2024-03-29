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
<title>View Student Details</title>
</head>
<body>

<div class="container">

<div class="titles">
<div class="row">
<div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
 <h1 class="fadeIn first">VIEW FACULTY</h1>
</div>
</div>
</div>

 <div class="wrapper fadeInDown">
            <div id="formContent">

  <form action="ViewFaculty" method="post" autocomplete="off">

                    <!-- user id text box -->
                    <div class="row">
                        <div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
                            <input type="number" class="fadeIn second"
                                name="faculty_Id" placeholder="faculty id" required="required">
                                
                        </div>
                    </div>
                    
                 <!-- submit button -->
                    <div class="row">
                        <div class="col-xs-12 col-sm-8 col-md-8 col-lg-12">
                            <input type="submit" class="fadeIn second" value="SUBMIT" onclick="alert('Deleted Successfully!');">
                            <br>
                        </div>
                    </div>
                    
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