package com.ajayaraj.olympicshop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajayaraj.olympicshop.service.CartItem;
import com.ajayaraj.olympicshop.service.OrderCart;

/**
 * Servlet implementation class ModifyCartServlet
 */
@WebServlet("/ModifyCartServlet")
public class ModifyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String actions = request.getParameter("user_action");
		String productid = request.getParameter("productid");
		int quantity = Integer.parseInt(request.getParameter("quantity").toString());
		
		HttpSession sessions = request.getSession();
		
		ArrayList<CartItem> existItem= (ArrayList)sessions.getAttribute("orderList");
		
		if(sessions.isNew() || existItem == null){
		
		//if (actions.equalsIgnoreCase("updatecart"))
		    handleUpdate(existItem, quantity ,productid);

		   sessions.setAttribute("orderList", existItem);
		}
		   RequestDispatcher view = request.getRequestDispatcher("displayProduct.jsp");
		   view.forward(request, response);
	}
	
	private void handleUpdate(ArrayList<CartItem> existingitem, int quantity, String productid){
		OrderCart shoppingcart = new OrderCart();
		shoppingcart.updateQuantity(existingitem, quantity, productid);
	}

}
