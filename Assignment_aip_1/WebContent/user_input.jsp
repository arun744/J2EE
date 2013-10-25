<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<linK href = "css/stylesheet.css" rel="stylesheet" type="text/css">
<title> User Information </title>
</head>
<body>
  <form action="ValidateServlet" method="post">
  <table>
  <tr>
    <td>Title:</td>
    <td>
       <input type="text" id="title" name="title" />
    </td>
  </tr>
  <tr>
    <td>
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
    <td>
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
    <td>
       Email:
    </td>
    <td>
      <input type="text" id = "email" name = "email" />
      
    </td>
  </tr>

  <tr>
    <td>
       Street Address:
    </td>
    <td>
      <input type="text" name = "details" />
      <div>
         <p id = "error"> ${errors.addressError}</p>
      </div>
    </td>
  </tr>
  
  <tr>
    <td>
       State:
    </td>
    <td>
      <input type="text" id="statename" name="statename"/>
    </td>
  </tr>
  
   <tr>
    <td>
       Country:
    </td>
    <td>
      <input type="text" id="countryname" name="countryname"/>
    </td>
  </tr>
  <tr>
  <td>
    <input type="submit" />
  </td>
  </tr>
  </table>
  
  
  </form>

</body>
</html>