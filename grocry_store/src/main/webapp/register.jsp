<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
<%@include file="includes/navbar.jsp" %>
<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Registration</div>
			<div class="card-body">
				<form action="registration" method="post">
					
					<div class="form-group">
						<label>Username</label> 
						<input type="text" name="username" class="form-control" placeholder="Enter username">
					</div>
					<div class="form-group">
						<label>Email address</label> 
						<input type="email" name="email" class="form-control" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="password" class="form-control" placeholder="Enter password">
					</div>
					<head>
						<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
					</head>
					<div class="text-center">
						<br>
						
						<button type="submit" class="btn btn-primary">Register!</button>
					</div>
				</form>
			</div>
		</div>
	</div>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script type="text/javascript">

	var status = document.getElementById("status").value;
	if(status == "success") {
		swal("Registration is successful!");
	}

</script>
</body>
</html>