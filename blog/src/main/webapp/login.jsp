<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Log In</title>
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
	</head>
	<body>
		<h1>Welcome</h1>
		<form action="/blog/user/loginResult">
			<label>Email</label><input id="email" name="email" type="text"/><br>
			<label>Password</label><input id="password" name="password" type="password"/><br>
			<input class="submit" type="submit" value="Enter">
		</form>
		<p>${message}</p>
	</body>
</html>