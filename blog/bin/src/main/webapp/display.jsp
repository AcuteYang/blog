
<!--%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Display Information</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/display.css">
</head>
<body>
	<div class="header">
		<div class="avator radius">
			<img class="small image" src="images/display-avator-image.jpg"/>
		</div>
		<div class="name">
			<h2>Aaron Guo
		</div>
		<div class="where">
			<div class="location">China</div>
			<div class="location">Shanghai</div>
			<div class="location">Shanghai</div>
		</div>
		<div>
			<div class="fields">
				<div class="number">5904</div>
				<div class="center number">16</div>
				<div class="number">500+</div>
			</div>
		</div>
		<div>
			<div class="icon">
				<div class="radius left">
					<i class="fa fa-commenting"></i>
				</div>
				<div class="radius right">
					<i class="fa fa-ellipsis-h"></i>
				</div>
			</div>
		</div>
	</div>
	<div class="profile">
		<div class="person">
			<div class="information">
				<div class="education card">
					<div class="column">
						<div class="attribute">Start</div>
						<div class="attribute">End</div>
						<div class="attribute">Degree</div>
						<div class="attribute">Major</div>
						<div class="attribute">School</div>
					</div>
					<div class="personal">
						<div class="data">2000-9-9</div>
						<div class="data">2004-9-9</div>
						<div class="data">Bachelor</div>
						<div class="data">Math</div>
						<div class="data">UDC</div>
					</div>
				</div>
			</div>
			<div class="information">
				<div class="work card">
					<div class="column">
						<div class="attribute">Start</div>
						<div class="attribute">End</div>
						<div class="attribute">Degree</div>
						<div class="attribute">Major</div>
						<div class="attribute">School</div>
					</div>
					<div class="personal">
						<div class="data">2000-9-9</div>
						<div class="data">2004-9-9</div>
						<div class="data">Bachelor</div>
						<div class="data">Math</div>
						<div class="data">UDC</div>
					</div>
				</div>
			</div>
		</div>
		<div class="blog card">
			<div>
				<h1>I am a blog</h1>
				<p>qwertyuiopasertyuiop[dfghjklsdfghjkldfghjklzxcvbnm</p>
			</div>
		</div>
		<div class="relation">
			<div class="stranger card">
				<div class="column">
					<div class="attribute">Name</div>
					<div class="attribute">Gender</div>
					<div class="attribute">Birthday</div>
				</div>
				<div class="personal">
					<div class="data">Thursday</div>
					<div class="data">Male</div>
					<div class="data">1999-9-10</div>
				</div>
			</div>
			<div class="friend card">
				<div class="column">
					<div class="attribute">Name</div>
					<div class="attribute">Gender</div>
					<div class="attribute">Birthday</div>
				</div>
				<div class="personal">
					<div class="data">Thursday</div>
					<div class="data">Male</div>
					<div class="data">1999-9-10</div>
				</div>
			</div>
		</div>
	</div>
	<!--<table>
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
	</table>-->
</body>
</html>