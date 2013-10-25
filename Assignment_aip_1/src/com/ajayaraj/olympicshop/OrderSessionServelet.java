package com.ajayaraj.olympicshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajayaraj.olympics.db.DatabaseBeanImpl;
import com.ajayaraj.olympics.db.DisplayProduct;
import com.ajayaraj.olympicshop.service.CartItem;
import com.ajayaraj.olympicshop.service.OrderCart;
import com.ajayaraj.olympicshop.service.Product;

/**
 * Servlet implementation class OrderSessionServelet
 */

public class OrderSessionServelet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	 ArrayList<CartItem> cartList = new ArrayList<CartItem>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSessionServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 doPost(req,resp);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		orderSession(request, response);       
	}
	
	
	private void orderSession (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String actions = request.getParameter("action");

		if(actions.equalsIgnoreCase("add"))
			//handleAddCart(cartList,newitem);
			handleAddCart(request);
		
		if(actions.equalsIgnoreCase("update"))
			handleUpdate(request);
		
		if(actions.equalsIgnoreCase("delete"))
			handleRemove(request);
		
		RequestDispatcher view = request.getRequestDispatcher("displayProduct.jsp");
	    view.forward(request, response);
		
	}
	
	
	private void handleAddCart(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		DatabaseBeanImpl productinfo = new DatabaseBeanImpl();
		String productid = request.getParameter("productid");
		Product newproduct = productinfo.displayProduct(productid);
		CartItem newitem = new CartItem(newproduct);
		
		OrderCart shoppingcart = new OrderCart();
		shoppingcart.addOrder(cartList, newitem);
		
		String totalamount = getCartTotal(cartList);
		session.setAttribute("totalprice", totalamount);
		
		session.setAttribute("orderList", cartList);
	}
	
	private void handleUpdate(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		ArrayList<CartItem> existingList = (ArrayList)session.getAttribute("orderList");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String productid = request.getParameter("product_id");
		OrderCart shoppingcart = new OrderCart();
		shoppingcart.updateQuantity(existingList, quantity, productid);
		
		String totalamount = getCartTotal(existingList);
		session.setAttribute("totalprice", totalamount);
		
		session.setAttribute("orderList", existingList);
		
	}
	
	private void handleRemove( HttpServletRequest request){
		
		HttpSession session = request.getSession();
		ArrayList<CartItem> existingList = (ArrayList)session.getAttribute("orderList");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String productid = request.getParameter("product_id");
		OrderCart shoppingcart = new OrderCart();
		shoppingcart.removeItem(existingList, productid);
		
		String totalamount = getCartTotal(existingList);
		session.setAttribute("totalprice", totalamount);
		
		session.setAttribute("orderList", existingList);
	}
	
	private String getCartTotal(ArrayList<CartItem> existingitem){
		String grandTotal;
		
		OrderCart shoppingcart = new OrderCart();
		grandTotal = String.valueOf(shoppingcart.getSubtotal(existingitem));
		
		return grandTotal;
	}

}
