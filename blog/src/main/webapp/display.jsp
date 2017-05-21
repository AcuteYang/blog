
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
	<div class="navigator">
		<div class="left">
			<i class="fa fa-search grey"></i>
			<input class="input" type="text" placeholder="Search here"/>
		</div>
		<div class="right">
			<div class="box">3</div>
			<div>
				<img class="photo" src="images/navigator-avatar.jpeg"/>
			</div>
		</div>
	</div>
	<div class="header">
		<div class="avatar radius">
			<img class="small image" src="images/display-avatar-image.jpg"/>
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
				<div class="title">Education</div>
				<div class="education card">
					<div class="logo">
						<i class="fa fa-university"></i>
					</div>
					<div class="personal">
						<div class="data">2000/9/9-2004/9/9</div>
						<div class="data">Bachelor Mathematics</div>
					</div>
				</div>
			</div>
			<div class="information">
				<div class="title">Work</div>
				<div class="work card">
					<div class="logo">
						<i class="fa fa-qq"></i>
					</div>
					<div class="personal">
						<div class="data">2000/9/9-2004/9/9</div>
						<div class="data">Tencent</div>
					</div>
				</div>
			</div>
		</div>
		<div class="blog">
			<div class="title">Blog</div>
			<div class="card">
				<div class="context">
					<h1>Endeavour</h1>
					<p>Endeavour is a British television detective drama series. It is a prequel to the long-running Inspector Morse and, like that series, is set primarily in Oxford. Shaun Evans portrays a young Endeavour Morse beginning his career as a Detective Constable with the Oxford City Police CID. The series is produced for ITV by Mammoth Screen and Masterpiece co-production for ITV Studios. Following a pilot episode in 2012, the first series was broadcast in 2013, the second in 2014 and the third in January 2016. A fourth series was ordered by ITV, began filming in late spring 2016,[1] and premiered on 8 January 2017.</p>
				</div>
			</div>
		</div>
		<div class="relation">
			<div class="title">Stranger</div>
			<div class="stranger card">
				<div class="minicard">
					<div class="photo">
						<img class="photo" src="images/avatar-1.jpg"/>
					</div>
					<div class="unknown">
						<div class="name">Trewlove</div>
						<div class="recommendation">China</div>
					</div>				
				</div>
				<div class="minicard">
					<div class="photo">
						<img class="photo" src="images/avatar-2.jpg"/>
					</div>
					<div class="unknown">
						<div class="name">Jakes</div>
						<div class="recommendation">China</div>
					</div>
				</div>	
				<div class="minicard">
					<div class="photo">
						<img class="photo" src="images/avatar-3.jpg"/>
					</div>
					<div class="unknown">
						<div class="name">Strange</div>
						<div class="recommendation">Computer Science</div>
					</div>
				</div>									
			</div>
			<div class="title">Friend</div>
			<div class="friend card">
				<div class="photo round">
					<img src="images/avatar-4.jpg"/>
				</div>
				<div class="photo round">
					<img src="images/avatar-5.jpg"/>
				</div>
				<div class="photo round">
					<img src="images/avatar-6.jpg"/>
				</div>
				<div class="photo round">
					<img src="images/avatar-7.jpg"/>
				</div>
				<div class="photo round">
					<img src="images/avatar-8.jpg"/>
				</div>
				<div class="photo round">
					<img src="images/avatar-9.jpg"/>
				</div>
				<div class="photo round">
					<img src="images/avatar-10.jpeg"/>
				</div>
				<div class="photo round">
					<img src="images/avatar-11.jpeg"/>
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