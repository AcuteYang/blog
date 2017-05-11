<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Information</title>
<link rel="stylesheet" type="text/css" href="css/display.css">
</head>
<body>
	<div class="image">
		
	</div>
	<table>
		<tr><th>Name</th><td>${user.getName()}</td></tr>
		<tr><th>Birthday</th><td>${user.getBirthday()}</td></tr>
		<tr><th>Gender</th><td>${user.getGender()}</td></tr>
		<tr><th>Country</th><td>${user.getCurrentLocation().getCountry()}</td></tr>
		<tr><th>State</th><td>${user.getCurrentLocation().getState()}</td></tr>
		<tr><th>City</th><td>${user.getCurrentLocation().getCity()}</td></tr>
	</table>
	<table>
		<tr><th>Name</th><th>Birthday</th><th>Gender</th><th>Country</th><th>State</th><th>City</th></tr>
		<c:forEach var="item" items="${user.getFriend()}">
			<tr><td>${item.getName()}</td>
			<td>${item.getBirthday()}</td>
			<td>${item.getGender()}</td>
			<td>${item.getCurrentLocation().getCountry()}</td>
			<td>${item.getCurrentLocation().getState()}</td>
			<td>${item.getCurrentLocation().getCity()}</td></tr>
		</c:forEach>
	</table>
	<table>
		<tr><th>Name</th><th>Birthday</th><th>Gender</th><th>Country</th><th>State</th><th>City</th><th>Request</th></tr>
		<c:forEach var="s" items="${stranger}">
			<tr><td>${s.getName()}</td>
			<td>${s.getBirthday()}</td>
			<td>${s.getGender()}</td>
			<td>${s.getCurrentLocation().getCountry()}</td>
			<td>${s.getCurrentLocation().getState()}</td>
			<td>${s.getCurrentLocation().getCity()}</td></tr>
			<td><form action="/blog/user/friend">
			<input name="userId" type="hidden" value="${user.getUserId()}"/>
			<input name="strangerId" type="hidden" value="${s.getUserId()}"/>
			<input name="send" type="submit" value="Send"/></form></td>
		</c:forEach>
	</table>
	<table>
		<tr><th>Sender</th><th>Receiver</th><th>Status</th></tr>
		<c:forEach var="req" items="${request}">
			<tr><td>${req.getSender().getName()}</td>
			<td>${req.getReceiver().getName()}</td>
			<td>${req.getRequestStatus().getStatusType()}</td></tr>
		</c:forEach>
	</table>
</body>
</html>