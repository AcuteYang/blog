<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Log In</title>
		<link rel="stylesheet" type="text/css" href="/blog/css/login.css"/>
		<link rel="stylesheet" type="text/css" href="/blog/css/style.css"/>
		<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
        <script src="/blog/script/vue.js"></script>
	</head>
	<body>
		<div class="login">
			<div class="they">
				<img src="/blog/images/login-1.jpg"/>
			</div>
			<div id="login" class="interface">
				<label>Email</label><br><input v-model="email" id="email" name="email" type="text"/><br>
				<label>Password</label><br><input v-model="password" id="password" name="password" type="password"/><br>
				<p class="message">{{message}}</p>
				<div class="enter">
				    <input v-on:click="requestLogin" class="submit" type="submit" value="ENTER">
				</div>
			</div>
		</div>
	
	<script src="/blog/script/login.js"></script>	
	</body>
</html>