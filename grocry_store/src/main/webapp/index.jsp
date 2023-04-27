<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cn.grocry_store.dao.ProductDao" %>
<%@page import="cn.grocry_store.connection.DbCon" %>
<%@page import="cn.grocry_store.model.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
  
    

<!DOCTYPE html>
<html>
<head>
<style>

.containerr {

	margin-left: 40px;
	margin-top: 600px;
}

</style>
<title>Insert title here</title>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
</body>
</html>
<div class="containerr">
<h3>
Welcome!
</h3>
<h5>This web application shows the report on the energy consumption of electrical devices in several buildings in the University Campus</h5>
<h5>To access this website, click on your desired button in the navigation bar above!</h5>
<br>
<ul>
  <li> Devices - to view all the devices </li>
  <li> Registration - To register as a user </li>
  <li> Login- To login and upload new devices </li>
</ul>
</div>
</body>

</html>