<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add A new Book</title>
</head>
<body>
<form action="addABook">  
Book Name : <input type="text" name="bookName"/><br/><br/>  
Price : <input type="number" name ="price"/><br/><br/> 
Year : <input type="number" name="year"/><br/><br/> 
Author Name: 
<select name="authorId">
  <option value="-" label ="--Select Author-->"></option>
   <c:forEach items= "${list}" var="author">
        <option value="${author.getAuthorId()}" label="${author.getAuthorName()}"></option>
        
      </c:forEach> 
</select><br>
<input type="submit" value="Add Book" /><br/><br/> 
</form>

</body>
</html>