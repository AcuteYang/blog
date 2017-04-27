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
		<label>Gender</label><select name="gender"><option value="F">Female</option><option value="M">Male</option></select><br>
		<label>Current Country</label><input name="country" type="text"/><label>short form within two letters</label><br>
		<label>Current State</label><input name="state" type="text"/><label>capitalized first letter</label><br>
		<label>Current City</label><input name="city" type="text"/><label>capitalized first letter</label><br>
		<input class="submit" type="submit" value="Submit"/>
	</form>
	<p>${message}</p>
</body>
</html>