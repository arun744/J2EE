package com.ajayaraj.olympicshop;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajayaraj.olympicshop.service.*;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Map<String, String> errors = new HashMap<String, String>();
		 UserValidation uservalidate = new UserValidation();
		 User user;
		 
		 String addressName = request.getParameter("details");
		 String firstname = request.getParameter("firstname");
		 String lastname = request.getParameter("lastname");
		 String email = request.getParameter("email");
		 String state = request.getParameter("statename");
		 String country = request.getParameter("countryname");
		 String creditcard = request.getParameter("creditcard");
		 String postcode = request.getParameter("postcode");
		 
	
		 boolean first_Nameresult = uservalidate.validateName(firstname);
		 boolean last_Nameresult = uservalidate.validateName(lastname);
		 boolean address_result = uservalidate.validateAddress(addressName);
		 boolean email_result = uservalidate.validateEmail(email);
		 boolean state_result = uservalidate.validateState(state);
		 boolean country_result = uservalidate.validateCountry(country);
		 boolean postcode_result = uservalidate.validatePost(postcode);
		 boolean credit_result = uservalidate.validateCredit(creditcard);
		 
		 if (first_Nameresult)
		 {
			 errors.put("fNameError", "Please enter the your first name");
		 }
		 
		 if (last_Nameresult){
			 errors.put("lnameError", "Enter Last name with first letter uppercase");
		 }
		 
		 if (email_result){
			 errors.put("emailError", "Enter email address eg:example@server.com");
		 }
		 
		 if(address_result)
			 errors.put("addressError", "Enter valid address eg: 12 Lane Street");
		 
		 if(state_result)
			 errors.put("stateError", "Enter state name");
		 
		 if(country_result)
			 errors.put("countryError", "Enter country name");
		 
		 if(postcode_result)
			 errors.put("postError", "Enter valid postcode in numbers");
		 
		 if(credit_result)
			 errors.put("creditError", "Enter valid credit card in numbers");
		 
		 if (errors.isEmpty()) {
		        user = new User("", firstname, lastname, email, addressName, state, country, postcode, creditcard);
		        HttpSession session = request.getSession();
		        session.setAttribute("uservalue", user);
		        request.getRequestDispatcher("confirmpage.jsp").forward(request, response);
		    } else {
		        request.setAttribute("errors", errors);
		        request.getRequestDispatcher("userPage.jsp").forward(request, response);
		    }

	}

}
