<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
 <%@page import="cn.grocry_store.model.*" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
 
 <%
 
 
 user auth = (user) request.getSession().getAttribute("auth");
 if(auth != null) {
 	request.setAttribute("auth", auth);
 }
 
 
 ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart-list");
 List<cart> cartProduct = null;
 if(cart_list != null) {
 	
 	request.setAttribute("cart_list",cart_list);	
 }

 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer Login</title>
<link href="index-styles.css" rel="stylesheet" />
</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
<%@include file="includes/navbar.jsp" %>
<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">USER LOGIN</div>
			<div class="card-body">
				<form name="myForm" action="loginform" method="post" onsubmit="return validateForm()">
					<div class="form-group">
						<label>Username</label> 
						<input id="username" type="username" name="username" class="form-control" placeholder="Enter username">
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input id="password" type="password" name="password" class="form-control" placeholder="Password">
					</div>
					<head>
						<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
					</head>
					<div class="text-center">
						<br>
						
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script type="text/javascript">

	var status = document.getElementById("status").value;
	if(status == "failed") {
		swal("Wrong username and password!!");
	}

</script>

<script src="validate.js"></script>

</body>
</html>