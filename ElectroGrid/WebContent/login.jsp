<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery.min.js"></script>
<script src="Components/login.js"></script>
<script src="Components/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="view-container">

			<form id="formlogin" name="formlogin" 
						action="index.jsp">
			<div class="content with-header">
				<div class="header">
					<f-icon class="ftnt-fortinet-grid icon-xl"></f-icon>
					<div>Employee Login</div>
				</div>
				<div class="sub-content">
					<div class="wide-inputs">
						Email:
						<input type="email" name="email" id="email"
							placeholder="email"> <br> Password :<input
							type="password" name="password" id="password" placeholder="Password"><br>
						<input type="submit" value="Login" id="btnlog" name="btnlog">
						
					</div>
				</div>
			</div>
		</form>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>