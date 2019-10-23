<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile !!!</title>
<style>
table, th, td {

  border: 1px solid black;
}
a:link, a:visited {
  background-color:purple;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: red;
}
</style>
</head>
<body>
<h1 align="center">My Profile</h1><br><br><br><br>

<table align="center">
<tr>
<th>StudentId</th>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>PhoneNumber</th>
<th>TenthPercentage</th>
<th>InterPercentage</th>
<th>AadharNumber</th>
<th>dob</th>
<th>DeprtmentName</th>
</tr>

<c:forEach items="${profile}" var="profilemodel">
<tr>
<td><c:out value="${profilemodel.student_id}"/></td>
<td><c:out value="${profilemodel.first_name}"/></td>
<td><c:out value="${profilemodel.last_name}"/></td>
<td><c:out value="${profilemodel.email}"/></td>
<td><c:out value="${profilemodel.phone_number}"/></td>
<td><c:out value="${profilemodel.tenth_percentage}"/></td>
<td><c:out value="${profilemodel.inter_percentage}"/></td>
<td><c:out value="${profilemodel.aadhar_number}"/></td>
<td><c:out value="${profilemodel.dob}"/></td>
<td><c:out value="${profilemodel.department_name}"/></td>
</tr>
</c:forEach>
</table>
<br><br><a href="AdminMainMenu.html"><b>Back</b></a> 
</body>
</html>