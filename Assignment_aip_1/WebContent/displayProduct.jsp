<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
           <div id ="positionContent">
           
               
                   <table id="ordertblstyle">
                     <tr>
                       <th id="orderheader">Product code</th>
                       <th id="orderheader">Description</th>
                       <th id="orderheader">Category</th>
                       <th id="orderheader">Price</th>
                       <th id="orderheader">Quantity</th>
                     </tr>
               <%
               
                 HttpSession sessions= request.getSession();
                 ArrayList<CartItem> cartList = (ArrayList)sessions.getAttribute("orderList");
                 String totalPrice = (String)sessions.getAttribute("totalprice");
                
               
                 
                 for(int index =0; index < cartList.size(); index++)
                 {
                %>
                
                     <tr>
                        <td id="orderrows"><%=cartList.get(index).getProductid() %></td>
                        <td id="orderrows"><%=cartList.get(index).getDescription() %></td>
                        <td id="orderrows"><%=cartList.get(index).getCategory()%></td>
                        <td id="orderrows"><%=cartList.get(index).totalPrice() %></td>
                        <td id="orderrows">
                          <form name="cartitem" method="POST" action="<%=request.getContextPath()%>/itemDisplay">
                             <input id ="quantitytxt" type = "text" name ="quantity"  value= <%=cartList.get(index).getQuantity() %> style="width: 66px;"/>
                             <p>
                               <input id="updatebtn" name ="action" type="submit" style="width: 61px; " value="Update">
                               <input id="deletebtn" name = "action" type="submit" style="width: 61px; " value="Delete">
                               <input type="hidden" name= "productid" value = "<%= index %>"/>
                               <input type="hidden" name= "product_id" value = "<%= cartList.get(index).getProductid() %>"/>
                             </p>
                          </form>
                        </td>
                     </tr>
                     
                  
                  <%
                  }
                   %>
                   </table>
             </div>
             <table>
                 <tr>
                   <td id="label2">Total amount $ <%= totalPrice %></td>
                   <td style="width: 241px; "></td>
                   <td><a href="<%=request.getContextPath()%>/productOflist"><img src="image/addmorebtn.png"/></a></td>
                   <td><a href="<%=request.getContextPath()%>/userPage.jsp"><img  src ="image/proceedbtn.png"/></a></td>
                 </tr>
             </table>
           </td>
        </tr>
      </table>
      </div>
    </div>
</body>
</html>