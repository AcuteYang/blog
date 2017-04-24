<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration</title>
</head>
<body>
	<form action="/blog/user/register">
		<label>Name</label><input name="name" type="text"/><br>
		<label>Email</label><input name="email" type="email"/><br>
		<label>Password</label><input name="password" type="password"/><br>
		<label>Password Confirmed</label><input name="passwordConfirmed" type="password"/><br>
		<label>Birthday</label><input name="birthday" type="date"/><br>
		<input class="submit" type="submit" value="Submit"/>
	</form>
	<p>${message}</p>
</body>
</html>