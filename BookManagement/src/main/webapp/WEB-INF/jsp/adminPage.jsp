<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.btn-group .button {
  background-color: #4CAF50; /* Green */
  border: 1px solid green;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  font-size: 16px;
  cursor: pointer;
  width: 350px;
  display: block;
}

.btn-group .button:not(:last-child) {
  border-bottom: none; /* Prevent double borders */
}

.btn-group .button:hover {
  background-color: #3e8e41;
}
</style>
</head>
<body>
<center>
<h2>Operations</h2>
<form target="_blank">
<div class="btn-group">
  <input type="submit" class= "button" value="View All Users" formaction="viewUsers"></input><br>
  <input type="submit" class= "button" value="View All Authors" formaction ="viewAuthors"></input><br>
  <input type="submit" class= "button" value="View All Books" formaction="viewBooks"></input><br>
  <input type="submit" class= "button" value="Add a Book" formaction="addBook"></input><br>
  <input type="submit" class= "button" value="Add a Author" formaction="addAuthor" ></input><br>
  <input type="submit" class= "button" value="Search book" formaction="searchBook"><br>
</div></form>
</center>
</body>
</html>