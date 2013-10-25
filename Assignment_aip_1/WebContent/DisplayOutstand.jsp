<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href = "css/stylesheet.css" rel="stylesheet" type="text/css">
<title>Outstanding order </title>
</head>
<body id ="oly_body">
   <div align="center">
        <table>
      <tr>
       <td>
       <img src = "image/logoaip.png" />
       </td>
      </tr>
      </table>
     <div id = "formWrap">
     
     <table>
      <tr>
        <td><img src = "image/updatetitle.png"/></td>
      </tr>
     </table>
       <table id = "margin_fields1">
          <tr>
          <td id="tbllabel">Update order</td>
          <td>
         <form action= "<%=request.getContextPath()%>/UpdateOrder" method="post" >   
          <select NAME = "typeoforder">
            <option value ="ORDERED"> ORDERED </option>
            <option value ="PAID"> PAID</option>
            <option value ="SENT"> SENT</option>
          </select>
          <input type="hidden" />  
          <input  type="submit" value = "Update" style="width: 89px; "/>
          <input name = "orderid" type="hidden" value="${orderID}"/>
         </form>
          </td>
          </tr>
       </table>
       
       <table id="customertblLyt" style="width: 408px; ">
       <tr>
         <th id="orderheader"> Customer Details</th>
       </tr>
       
       <tr>
         <td>
           <table style="width: 374px; ">
              <tr>
               <td id="tbllabel">First Name: </td>
               <td>${customer.firstName}</td>
              </tr>
              
               <tr>
               <td id="tbllabel">Last Name: </td>
               <td>${customer.lastName}</td>
              </tr>
              
               <tr>
               <td id="tbllabel" style="width: 139px; ">Address: </td>
               <td>${customer.streetName}, <br> ${customer.state}, <br> ${customer.postcode}, <br> ${customer.country}.</td>
              </tr>
              
              <tr>
                 <td id="tbllabel">Email:</td>
                 <td> ${customer.email}</td>
               </tr>
               
               <tr>
                 <td id="tbllabel">Credit card:</td>
                 <td> ${customer.creditnum}</td>
               </tr>
               
               <tr>
                 <td id="tbllabel">Status:</td>
                 <td> ${orderstatus.status}</td>
               </tr>
               
               <tr>
                 <td id="tbllabel">Amount:</td>
                 <td> ${orderstatus.totalprice}</td>
               </tr>
               
           </table>
         </td>
       </tr>
     </table>
       
       <div id = "positionContent">
            <table>
              <tr>
                <th id="orderheader">ProductID</th>
                <th id="orderheader">Name</th>
                <th id="orderheader" style="width: 118px; ">Description</th>
                <th id="orderheader">Quantity</th>
                <th id="orderheader">Amount</th>
              </tr>
            
             <c:forEach var="viewlist" items="${productList}">    
              <tr>
                <td id="orderrows">${viewlist.productid}</td>
                <td id="orderrows">${viewlist.category}</td>
                <td id="orderrows">${viewlist.description}</td>
                <td id="orderrows">${viewlist.quantity}</td>
                <td id="orderrows">${viewlist.totalcost}</td>
              </tr>
              </c:forEach>
            </table>
       </div>
     </div>
   </div>
</body>
</html>