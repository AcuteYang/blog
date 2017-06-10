<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration</title>
	<script src="/blog/script/vue.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="/blog/css/style.css"/>
	<link rel="stylesheet" type="text/css" href="/blog/css/register.css"/>
</head>

<body>
	<div id="register">
		<div class="header">
			<div class="headline">
				<div class="float left" v-on:click="basicClick">
					<div class="float radius pointer" v-bind:class="{chosen:basicChosen}">1</div>
					<div class="float column pointer" v-bind:class="{chosen:basicChosen}">Basic Information</div>
				</div>
				<div class="float middle" v-on:click="eduClick">
					<div class="float radius pointer" v-bind:class="{chosen:eduChosen}">2</div>
					<div class="float column pointer" v-bind:class="{chosen:eduChosen}">Education</div>
				</div>
				<div class="float right" v-on:click="workClick">
					<div class="float radius pointer" v-bind:class="{chosen:workChosen}">3</div>
					<div class="float column pointer" v-bind:class="{chosen:workChosen}">Work</div>
				</div>
			</div>
		</div>
		<h1>Fulfill your information</h1>
	        <div class="page" v-bind:class="{visible:basicChosen}">
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
								<input v-bind:class="{error:dateError}" v-model="birthdayYear" v-on:change="dateValidation" 
								name="birthdayYear" type="text" placeholder="yyyy" maxlength=4/>
								<input v-bind:class="{error:dateError}" v-model="birthdayMonth" v-on:change="dateValidation" 
								name="birthdayMonth" type="text" placeholder="MM" maxlength=2/>
								<input v-bind:class="{error:dateError}" v-model="birthdayDay" v-on:change="dateValidation" 
								name="birthdayDay" type="text" placeholder="dd" maxlength=2/>
							</div>
						</div>
						<div class="half"><label>Gender</label><input v-model="gender" name="gender" type="text" placeholder="Female/Male"></div>
					</div>
					<label>Country</label><br><input v-model="country" name="country" type="text" placeholder="capitalized initial"/><br>
					<label>State</label><br><input v-model="state" name="state" type="text" placeholder="capitalized initial"/><br>
					<label>City</label><br><input v-model="city" name="city" type="text" placeholder="capitalized initial"/><br>
				</div>
				<div class="radius pointer turner">
	                <i class="fa fa-angle-right" v-on:click="eduClick"></i>
				</div>
			</div>
			<div class="page" v-bind:class="{visible:eduChosen}">
	            <div class="radius pointer turner">
	                <i class="fa fa-angle-left" v-on:click="basicClick"></i>
	            </div>
	            <div>
		            <label>Start</label>
		            <input type="text" placeholder="yyyy" maxlength=4>
		            <input type="text" placeholder="MM" maxlength=2>
		            <input type="text" placeholder="dd" maxlength=2>
	            </div>
	            <div>
		            <label>End</label>
		            <input type="text" placeholder="yyyy" maxlength=4>
		            <input type="text" placeholder="MM" maxlength=2>
		            <input type="text" placeholder="dd" maxlength=2>
	            </div>
	            <div>
		            <label>School</label>
		            <input type="text">
		            <label>Degree</label>
		            <input type="text">
		            <label>Major</label>
		            <input type="text">
	            </div>
	            <div class="radius pointer turner">
	                <i class="fa fa-angle-right" v-on:click="workClick"></i>
	            </div>
			</div>
			<div class="page" v-bind:class="{visible:workChosen}">
	            <div class="radius pointer turner">
	                <i class="fa fa-angle-left" v-on:click="eduClick"></i>
	            </div>
	            <div>		
		            <label>Start</label>
		            <input type="text" placeholder="yyyy" maxlength=4>
		            <input type="text" placeholder="MM" maxlength=2>
		            <input type="text" placeholder="dd" maxlength=2>
		        </div>
		        <div>
	                <label>End</label>
		            <input type="text" placeholder="yyyy" maxlength=4>
		            <input type="text" placeholder="MM" maxlength=2>
		            <input type="text" placeholder="dd" maxlength=2>
	            </div>
	            <div>
		            <label>Company</label>
		            <input type="text">
		            <label>Country</label>
		            <input type="text">
		            <label>State</label>
		            <input type="text">
		            <label>City</label>
		            <input type="text">
	            </div>
			</div>
			<div class="enter">
				<input class="submit" type="submit" value="Submit"/>
			</div>
	</div>	
	<script src="/blog/script/register.js"></script>
</body>
</html>