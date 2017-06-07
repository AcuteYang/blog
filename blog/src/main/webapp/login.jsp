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
		<div id="login" class="login">
			<div class="they">
				<img src="/blog/images/login-1.jpg"/>
			</div>
			<div class="interface">
                <div class="option">
                    <div v-bind:class="{email:emailChosen}" v-on:click="emailClick" class="pointer">Email</div>
                    <div v-bind:class="{name:nameChosen}" v-on:click="nameClick" class="pointer">Name</div>
                </div>
				<input v-model="unique" id="email" name="email" type="text"/><br>
				<div class="option">
				    <div v-bind:class="{email:emailChosen}">Password</div>
				    <div v-bind:class="{name:nameChosen}">Password</div>
				</div>
				<input v-model="password" id="password" name="password" type="password"/><br>
				<p class="message">{{message}}</p>
				<div class="enter">
				    <input v-on:click="requestLogin" class="submit" type="submit" value="ENTER">
				</div>
			</div>
		</div>
	
	<script src="/blog/script/login.js"></script>	
	</body>
</html>