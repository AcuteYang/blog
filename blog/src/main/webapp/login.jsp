<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>-->
<!DOCTYPE html>
<html>
	<head>
		<title>Log In</title>
		<link rel="stylesheet" type="text/css" href="/blog/css/style.css"/>
		<link rel="stylesheet" type="text/css" href="/blog/css/login.css"/>
	</head>
	<body>
		<div class="login">
			<div class="they">
				<img src="/blog/images/login-1.png"/>
			</div>
			<div class="interface">
				<form action="/blog/user/loginResult">
					<label>Email</label><br><input id="email" name="email" type="text"/><br>
					<label>Password</label><br><input id="password" name="password" type="password"/><br>
					<div class="enter"><input class="submit" type="submit" value="ENTER"></div>
				</form>
				<p class="message">${message}</p>
			</div>
		</div>
		
	</body>
</html>