<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration</title>
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<link rel="stylesheet" type="text/css" href="css/register.css"/>
</head>

<body>
	<div class="header">
		<div class="headline">
			<div class="float left">
				<div class="float radius chosen">1</div>
				<div class="float column current">Basic Information</div>
			</div>
			<div class="float middle">
				<div class="float radius">2</div>
				<div class="float column">Education</div>
			</div>
			<div class="float right">
				<div class="float radius">3</div>
				<div class="float column">Work</div>
			</div>
		</div>
	</div>
	<h1>Fulfill your information</h1>
	<form action="/blog/user/register">
		<div class="form left">
			<label>Name</label><br><input name="name" type="text"/><br>
			<label>Email</label><br><input name="email" type="email"/><br>
			<label>Password</label><br><input name="password" type="password"/><br>
			<label>Password Confirmed</label><br><input name="passwordConfirmed" type="password"/><br>
		</div>
		<div class="form right">
			<div class="two">
				<div class="half"><label>Birthday</label><input name="birthday" type="text" placeholder="yyyy-MM-dd"/></div>
				<div class="half"><label>Gender</label><input name="gender" type="text" placeholder="Female/Male"></div>
			</div>
			<label>Country</label><br><input name="country" type="text" placeholder="capitalized initial"/><br>
			<label>State</label><br><input name="state" type="text" placeholder="capitalized initial"/><br>
			<label>City</label><br><input name="city" type="text" placeholder="capitalized initial"/><br>
		</div>
		<div class="enter">
			<input class="submit" type="submit" value="Submit"/>
		</div>
	</form>
	<p class="message">${message}</p>
</body>
</html>