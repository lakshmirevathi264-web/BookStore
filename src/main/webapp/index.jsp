<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Book Store Login</title></head>
<body>
<h2>Online Book Store Login</h2>
<% if(request.getAttribute("error") != null){ %>
    <p style="color:red;"><%= request.getAttribute("error") %></p>
<% } %>
<form action="login" method="post">
    Username: <input type="text" name="username" value="user1"><br>
    Password: <input type="password" name="password" value="pass123"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>