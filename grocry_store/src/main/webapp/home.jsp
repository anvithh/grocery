<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
h3, p {
	margin-left:30px;
}

.container {
    width:00%;
    overflow:auto;
    box-sizing: border-box;
}

.form {
    
    height:450px;
    float:center;
    text-align: center;
    font-size: 20px;
}

.form1 {
    background:#ccc;
}

.form2 {
    background:#999;
}

.timepass {
	font-size: 25px;
}

.check {
	margin-left: 85px;
}

.form-control {
	text-align: center;
}

</style>



</head>

<body>
<%@include file="includes/navbar.jsp" %>
<br>
<h3>Welcome user!</h3>
<p>Please enter the details of the devices by entering the below form:</p>


<div class="container">
    <div class="form form1"><b class="timepass">UPLOAD NEW DEVICES</b>
    	<form action="uploadform" method="post">
					<div class="form-group">
						<br></br>
						<label>Name of the device</label> 
						<input type="text" name="name" class="form-control" placeholder="Name of the device">
					</div>
					<div class="form-group">
						<label>Building it belongs to</label> 
						<input type="text" name="building" class="form-control" placeholder="Building">
					</div>
					<div class="form-group">
						<label>Consumption</label> 
						<input type="text" name="consumption" class="form-control" placeholder="Consumption">
					</div>
					<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
					<button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </div>


</body>
</html>