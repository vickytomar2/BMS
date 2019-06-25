<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users List</title>
</head>
<body>
  <table border="2" width="70%" cellpadding="2">  
<tr><th>Email Id</th><th>Name</th><th>isAdmin</th><th>Password</th></tr>  
   
   
   <c:forEach var="User" items="${list}">
   <tr>  
   
   <td>${User.email}</td>  
   <td>${User.name}</td>  
   <td>${User.isadmin}</td>
   <td>${User.password}</td>
    <td><a href="deleteUser/${User.email}">Delete</a></td>
   </tr>  
   </c:forEach>
   </table>
</body>
</html>