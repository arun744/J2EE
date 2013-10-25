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
     <div id = "prodform">
     
     <table>
      <tr>
        <td><img src = "image/outstandtitle.png"/></td>
      </tr>
     </table>
       <table >
          <tr>
          <td>
         <form action= "<%=request.getContextPath()%>/OutstandDisplay" method="get" >   
          <select NAME = "ordertype">
            <option value = "">Select Order type  </option>
            <option value ="ORDERED"> ORDERED </option>
            <option value ="PAID"> PAID</option>
          </select>
          <input type="hidden" />  
          <input  type="submit" value = "Search" style="width: 89px; "/>
         </form>
          </td>
          </tr>
       </table>
       
       <div id = "positionContent">
          <table>
           <tr>
             <th id="orderheader">Order number </th>
             <th id="orderheader">Lastname</th>
             <th id="orderheader">Country</th>
             <th id="orderheader">Postcode</th>
             <th id="orderheader">Amount</th>
             <th id="orderheader">Status</th>
           </tr>
          
          <c:forEach var="viewlist" items="${outstandList}">  
           <tr>
             <td  id="orderrows">
             <form action= "<%=request.getContextPath()%>/DisplayOrder" method="get" >
               <input id="orderback" type = "submit" value="${viewlist.orderID}" style="height: 40px; "/>
               <input type="hidden" name= "ordernum" value="${viewlist.orderID}"/>
               <input type="hidden" name= "surname" value="${viewlist.lastName}"/>
             </form>
             </td>
             <td  id="orderrows">${viewlist.lastName}</td>
             <td  id="orderrows">${viewlist.country}</td>
             <td  id="orderrows">${viewlist.postcode}</td>
             <td  id="orderrows">${viewlist.amount}</td>
             <td  id="orderrows">${viewlist.status}</td>
           </tr>
          </c:forEach>
          </table>
       </div>
       
     </div>
   </div>
</body>
</html>