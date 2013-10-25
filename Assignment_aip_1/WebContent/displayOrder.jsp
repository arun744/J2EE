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
<title>Search Order </title>
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
                <img src="image/searchtitle.png" />
              </td>
             </tr>
           </table>
           <table>
           <tr>
             <th id="orderheader">Enter to Search</th>
           </tr>
                  <tr>
                   <td>
                   <form action= "<%=request.getContextPath()%>/SearchDisplay" method = "get">
                   <p>
                     Order Number: <input type="text" name = "orderid"/>
                     Surname: <input type="text" name = "surname"/>
                     <input type="submit"  value = "search"/>
                   </p>  
                   </form>
                   </td>
                  </tr>
               </table>
               
               <table>
               <tr>
                 <td id="label2"> Status :  ${orderview.status}</td>
               </tr>
               </table>
           <div id ="positionContent">
               <table>
                 <tr>
                   <th id="orderheader">Product ID</th>
                   <th id="orderheader">Name </th>
                   <th id="orderheader">Description</th>
                   <th id="orderheader">Quantity</th>
                   <th id="orderheader">Total Price</th>
                 </tr>
               
               <c:forEach var="viewlist" items="${viewList}">  
                 <tr>
                 <td id="orderrows"><c:out value="${viewlist.getProductid()}"/></td>
                 <td id="orderrows"><c:out value="${viewlist.getCategory()}"/></td>
                 <td id="orderrows"><c:out value="${viewlist.getDescription()}"/></td>
                 <td id="orderrows"><c:out value="${viewlist.getQuantity()}"/></td>
                 <td id="orderrows"><c:out value="${viewlist.getTotalcost()}"/></td>
                 </tr>
               </c:forEach>
               </table>
           </div>
           <table>
           <tr>
             <td id="label2"> Total Price: ${orderview.totalprice}</td>
           </tr>
           </table>
    </div>
</body>
</html>