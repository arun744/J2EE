<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href = "css/stylesheet.css" rel="stylesheet" type="text/css">
<title>Welcome to administration </title>
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
     <div id = "adminformWrap">
       <table id="margin_form">
          <tr>
           <td><a href="<%=request.getContextPath()%>/outstanding.jsp"><img src = "image/outstandbtn.png"/></a></td>
           <td><a href="<%=request.getContextPath()%>/manualOutstand.jsp"><img src = "image/adminupdatebtn.png"/></a></td>
          </tr>
       </table>
     </div>
   </div>
</body>
</html>