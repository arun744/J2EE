<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.ajayaraj.olympicshop.ReadTextFile" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<linK href = "css/stylesheet.css" rel="stylesheet" type="text/css">
<title>Australia Online shopping - London 2012</title>
</head>
<body id ="oly_body">
<%  ReadTextFile displayContent = new ReadTextFile(); %>
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
        <td width="592">
        <table align="left"  id = "container">
         <tr id = "title_style">
            <td >
              <img src = "image/hometitle_head.png"/>
            </td>
         </tr>
         
         <tr>
         <td>
           <img src  = "image/london2012.jpg"/>
         </td>
         </tr>
         <tr>
            <td>
                <p id = "container_main">
                 <%= displayContent.readFile("/Homeinfo.txt")%>
                
                </p>
             </td>
         </tr>
        </table>
        </td>
        </tr>
      </table>
      </div>
    </div>
</body>
</html>