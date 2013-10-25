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
                <img src="image/customertitle.png" />
              </td>
             </tr>
           </table>
           
           <div id ="positionContent">
           
<form action="ValidateServlet" method="post">
  <table>
  <tr>
    <td id="orderheader">Title:</td>
    <td>
       <input type="text" id="title" name="title" />
    </td>
  </tr>
  <tr>
    <td id="orderheader">
       First Name:
    </td>
    <td>
      <input type="text" id="firstname" name="firstname"/>
      <div>
         <p id = "error"> ${errors.fNameError}</p>
      </div>
    </td>
  </tr>
  
  <tr>
    <td id="orderheader">
       Last Name:
    </td>
    <td>
      <input type="text" id="lastname" name="lastname"/>
      <div>
         <p id = "error"> ${errors.lnameError}</p>
      </div>
    </td>
  </tr>
  
  
  <tr>
    <td id="orderheader">
       Email:
    </td>
    <td>
      <input type="text" id = "email" name = "email" />
       <div>
         <p id = "error"> ${errors.emailError}</p>
      </div>
    </td>
  </tr>

  <tr>
    <td id="orderheader">
       Street Address:
    </td>
    <td>
      <input type="text" id = "details" name = "details" />
      <div>
         <p id = "error"> ${errors.addressError}</p>
      </div>
    </td>
  </tr>
  
  <tr>
    <td id="orderheader">
       State:
    </td>
    <td>
      <input type="text"  name="statename"/>
      <div>
         <p id = "error"> ${errors.stateError}</p>
      </div>
    </td>
  </tr>
  
   <tr>
    <td id="orderheader">
       Country:
    </td>
    <td>
      <input type="text"  name="countryname"/>
      <div>
         <p id = "error"> ${errors.countryError}</p>
      </div>
    </td>
  </tr>
  
  <tr>
    <td id="orderheader">
       Postcode:
    </td>
    <td>
      <input type="text"  name="postcode"/>
      <div>
         <p id = "error"> ${errors.postcodeError}</p>
      </div>
    </td>
  </tr>
  
  <tr>
    <td id="orderheader">
       Credit card No:
    </td>
    <td>
      <input type="text"  name="creditcard"/>
      <div>
         <p id = "error"> ${errors.creditError}</p>
      </div>
    </td>
  </tr>
  <tr>
  <td>
    <input type="submit" />
  </td>
  </tr>
  </table>
           </div>
    </div>
</body>
</html>