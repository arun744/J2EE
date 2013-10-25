<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "com.ajayaraj.olympicshop.ReadTextFile" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ajayaraj.olympicshop.service.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<linK href = "css/stylesheet.css" rel="stylesheet" type="text/css">
<title>Australia Online shopping - London 2012</title>
</head>
<body id ="oly_body">
    <div  align="center" >
      <table>
      <tr>
       <td>
       <img src = "image/logoaip.png" />
       </td>
      </tr>
      </table>
      
      <div id = "formWrap">
      <table  id = "content_tbl">
        <tr>
        <td  id = "left_container">
      
        <table  id = "leftnavi" >

        <tr>
           <td>
           <img src="image/homebtn.png" />
           </td>
        </tr>
        
        <tr>
           <td>
           <a  href="<%=request.getContextPath()%>/productOflist">
              <img src="image/product_menu.png" />
           </a>
           </td>
        </tr>
        <tr>
           <td>
             <a href="<%=request.getContextPath()%>/aboutus.jsp">
                <img src="image/about_menu.png" />
             </a>
           </td>
        </tr>
        <tr>
           <td><img src="image/ass_menu.png" /></td>
        </tr>
        
        <tr>
           <td>
             <a href="<%=request.getContextPath()%>/displayOrder.jsp">
                <img src="image/searchbtn.png" />
             </a>
           </td>
        </tr>
        <tr>
           <td>
             <p> Administration </p>
              <a href = "<%=request.getContextPath()%>/admin_login.jsp">
                <img src="image/admin-btn.png" />
              </a> 
           </td>
        </tr>
       
         </table>
        </td>
        <td width="592" height= "600" id = "left_container">
        <table >
             <tr>
              <td>
                <img src="image/orderformtitle.png" />
              </td>
             </tr>
           </table>
           
           <%
             // ArrayList <CartItem> cartItems = (ArrayList<CartItem>)request.getAttribute("cartItems");
            
            %>
           
             <table>
               <tr>
                 <th id="orderheader">
                 Your details
                 </th>
               </tr>
               <tr>
               <td >
                  <p>First name: ${uservalue.firstName}</p>
                  <p>Last name: ${uservalue.lastName}</p>
                  <p>Email:  ${uservalue.email }</p>
                  <p>Address: ${uservalue.streetName }</p>
                  <p>credit card no: ${uservalue.creditnum}</p>
               </td>
               </tr>
             </table>
             
             <div id ="positionContent">
             <table id="ordertblstyle" >
               <tr>
                 <th id="orderheader">Category</th>
                 <th id="orderheader">ProductID</th>
                 <th id="orderheader">Description</th>
                 <th id="orderheader">Quantity</th>
                 <th id="orderheader">Price</th>
               </tr>
               
               <c:forEach var="cartList" items="${orderList}">
               <tr>
                 <td id="orderrows"><c:out value="${cartList.getCategory()}"/></td>
                 <td id="orderrows"><c:out value="${cartList.getProductid()}"/></td>
                 <td id="orderrows"><c:out value="${cartList.getDescription()}"/></td>
                 <td id="orderrows"><c:out value="${cartList.getQuantity()}" /></td>
                 <td id="orderrows"><c:out value="${cartList.totalPrice()}"/></td>
               </tr>
               </c:forEach>
             </table>
           </div>
           
           <table>
             <tr>
                <td>
                  <form method="post" action="<%=request.getContextPath()%>/finalDisplay">
                    <input id = "confirmbtn" type="submit" value="" />
                  </form>
                </td>
             </tr>
           </table>
    </div>
</body>
</html>