<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>Admin</title>
</head>
<body>
	<div id="wrap">
		<div id="container">
			<table id="order">
				<thead>
					<tr>
						<th>Order Number</th>
						<th>Surname</th>
						<th>Country</th>
						<th>Postcode</th>
						<th>Grand Total of order</th>
						<th>Status Code</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${orders}">
						<tr>
							<td>${order.orderId}</td>
							<td>${order.customer.surname}</td>
							<td>${order.customer.country}</td>
							<td>${order.customer.postcode}</td>
							<td>$${order.cart.totalPrice}</td>
							<td>${order.status}</td>
							<td><a href="admin?action=select&orderId=${order.orderId}&customerId=${order.customer.customerId}">Select</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
