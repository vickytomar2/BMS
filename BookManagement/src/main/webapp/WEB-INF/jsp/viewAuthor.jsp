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
<tr><th>Author Id</th><th>Author Name</th></tr>  
   
   
   <c:forEach var="auth" items="${list}">
   <tr>  
   
   <td>${auth.authorId}</td>  
   <td>${auth.authorName}</td>  
   <td><a href="deleteAuthor/${auth.authorId}">Delete</a></td>  
 
   </tr>  
   </c:forEach>
   </table>
</body>
</html>