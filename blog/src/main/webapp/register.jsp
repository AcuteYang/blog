<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration</title>
	<script src="/blog/script/vue.js"></script>
	<link rel="stylesheet" type="text/css" href="/blog/css/style.css"/>
	<link rel="stylesheet" type="text/css" href="/blog/css/register.css"/>
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
		<div id="left" class="form left">
			<label>Name</label><br><input v-model="name" name="name" type="text"/><br>
			<label>Email </label><label class="errorMessage">{{emailMismatch}}</label><br>
				<input placeholder="user@email.com" v-bind:class="{error:emailError}" v-on:change="emailValidation" v-model="email" name="email" type="email"/><br>
			<label v-on:click="displayPwd">Password</label><label class="errorMessage">{{passwordMismatch}}</label><br>
				<input id="pwd" v-bind:class="{error:passwordError}" v-on:change="passwordValidation" v-model="password"  placeholder="6-25 characters"name="password" type="password"/><br>
			<label>Password Confirmed</label><label class="errorMessage">{{passwordConfirmedMismatch}}</label><br>
				<input v-bind:class="{error:passwordConfirmedError}" v-on:change="passwordMatch" v-model="passwordConfirmed" name="passwordConfirmed" type="password"/><br>
		</div>
		<div id="right" class="form right">
			<div class="two">
				<div class="half"><label>Birthday</label><label class="errorMessage">{{dateMismatch}}</label>
					<div class="three">
						<input v-bind:class="{error:dateError}" v-model="birthdayYear" v-on:change="dateValidation" name="birthdayYear" type="text" placeholder="yyyy" maxlength=4/>
						<input v-bind:class="{error:dateError}" v-model="birthdayMonth" v-on:change="dateValidation" name="birthdayMonth" type="text" placeholder="MM" maxlength=2/>
						<input v-bind:class="{error:dateError}" v-model="birthdayDay" v-on:change="dateValidation" name="birthdayDay" type="text" placeholder="dd" maxlength=2/>
					</div>
				</div>
				<div class="half"><label>Gender</label><input v-model="gender" name="gender" type="text" placeholder="Female/Male"></div>
			</div>
			<label>Country</label><br><input v-model="country" name="country" type="text" placeholder="capitalized initial"/><br>
			<label>State</label><br><input v-model="state" name="state" type="text" placeholder="capitalized initial"/><br>
			<label>City</label><br><input v-model="city" name="city" type="text" placeholder="capitalized initial"/><br>
		</div>
		<div class="enter">
			<input class="submit" type="submit" value="Submit"/>
		</div>
	</form>
	<p class="message">${message}</p>
	<script src="/blog/script/register.js"></script>
</body>
</html>