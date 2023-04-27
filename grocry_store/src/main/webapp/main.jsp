<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.List" %>
<%@page import="cn.grocry_store.connection.DbCon" %>
<%@page import="cn.grocry_store.model.*" %>
<%@page import="cn.grocry_store.dao.ProductDao" %>

<%
ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> products = pd.getAllProducts();
%>

<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Products</title>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

</head>
<body>

<div class="container">
	<div class="card-header my-2">All the devices:</div>
	<div class="row">
	<%
		if( !products.isEmpty()) {
			for(Product p:products) {%>
				<div class="col-md-3 my-5">
				<div class="card w-100" style="width:14rem;">
					
					<div class="card-body">
						<h5 class="card-title"><%=p.getName() %></h5>
						<head>
							<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
						</head>
						
						<h6 class="price">Consumption: <%=p.getPrice() %>units</h6>
						
						<h6 class="description">Building: <%=p.getDescription() %></h6>
						
					</div>
				</div>
			</div>
			<%}
		}
	%>
	</div>
</div>



</body>
</html>