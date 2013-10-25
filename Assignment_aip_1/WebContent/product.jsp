<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<linK href = "css/stylesheet.css" rel="stylesheet" type="text/css">
<title>Shopping Product</title>
</head>
<body  id ="oly_body">
    <div  align="center">
        <table>
      <tr>
       <td>
       <img src = "image/logoaip.png" />
       </td>
      </tr>
      </table>
      
      <div id = "prodform">
      <table  id = "content_tbl">
        <tr>
        <td  id = "left_container">
      
        <table  id = "leftnavi" >

        <tr>
           <td>
           <a  href="<%=request.getContextPath()%>/index.jsp">
           <img src="image/homebtn.png" />
           </a>
           </td>
        </tr>
        
        <tr>
           <td>
           <a  href="<%=request.getContextPath()%>/product.jsp">
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
        <td>
        
        <table align="left"  id = "left_container">
         <tr id = "title_style">
            <td >
              <img src = "image/producttitle.png"/>
            </td>
         </tr>
      </table>
     
      <table id="sub_menu">
      <tr>
          <td id = "hyperlabel"><a href="productOflist?prod_category=medals">Medals</a></td>
          <td id = "hyperlabel"><a href="productOflist?prod_category=flags">Flags</a></td>
          <td id = "hyperlabel"><a href="productOflist?prod_category=ribbons">Ribbons</a></td>
          <td id = "hyperlabel"><a href="productOflist?prod_category=badges">Badges</a></td>
          <td id = "hyperlabel"><a href="productOflist?prod_category=pins">Pins</a></td>
          <td id = "hyperlabel"><a href="productOflist?prod_category=stationery">Stationary</a></td>
          <td id = "hyperlabel"><a href="productOflist?prod_category=toys">Toys</a></td>
          <td id = "hyperlabel"><a href="productOflist?prod_category=miscellaneous">Miscellaneous</a></td>
      </tr>
      </table>
      
      <c:choose>
        <c:when test="${not empty productCategory}">
                    <p id = "label1">Category for: ${productCategory}</p>
                 </c:when>
                 <c:otherwise>
                    <p id = "label1"> Category for: all Items</p>
                 </c:otherwise>
      </c:choose>
 <div id = "positionContent">     
 <table>
   <tr>
      
   </tr>
 </table>
 <table id = "sequence" >
          <tr >
             <c:if test="${currentPage != 1}">
                <td id = "direction"><a href="productOflist?page=${currentPage - 1}&prod_category=${productCategory}"> << Previous</a></td>
             </c:if>
             <c:forEach begin= "1" end="${noOfPages}" var = "index">
               <c:choose>
                 <c:when test="${currentPage eq index }">
                    <td id="paddingseq">${index}</td>
                 </c:when>
                 <c:otherwise>
                 <td id="paddingseq"><a href="productOflist?page=${index}&prod_category=${productCategory}">${index}</a></td>
                 </c:otherwise>
               </c:choose>
             </c:forEach>
             <c:if test="${currentPage lt noOfPages}">
                <td id = "direction"><a href="productOflist?page=${currentPage + 1}&prod_category=${productCategory}">Next >></a></td>
             </c:if>
          </tr>
          
      </table>
     
      <table id="tableformat">
        <tr>
           <th id = "prodtblhead">Category</th>
           <th id = "prodtblhead">Description</th>
           <th id = "prodtblhead">Price(AU $)</th>
        </tr>
        
        <c:forEach var="product" items="${productlist}">
           <tr >
              <td id="prodtblrow">${product.category}</td>
              <td id="prodtblrow">${product.description}</td>
              <td id="prodtblrow">${product.price}</td>
           </tr>
           <tr>
           <td>
           <form name="items" method="POST" action="<%=request.getContextPath()%>/itemDisplay">
              <input id = "addcartbtn" type="submit" value=""/>
              <input type="hidden" name="action" value="add">
              <input type="hidden" name="productid" value="${product.code }"/>
           </form>
           </td>
           </tr>
        </c:forEach>
      </table>
      </div>
      </div>
    </div>
</body>
</html>