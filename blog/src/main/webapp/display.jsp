<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Information</title>
</head>
<body>
	<table>
		<tr><th>Name</th><td>${user.getName()}</td></tr>
		<tr><th>Birthday</th><td>${user.getBirthday()}</td></tr>
		<tr><th>Gender</th><td>${user.getGender()}</td></tr>
		<tr><th>Country</th><td>${user.getCurrentLocation().getCountry()}</td></tr>
		<tr><th>State</th><td>${user.getCurrentLocation().getState()}</td></tr>
		<tr><th>City</th><td>${user.getCurrentLocation().getCity()}</td></tr>
	</table>

</body>
</html>