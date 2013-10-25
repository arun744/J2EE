package com.ajayaraj.olympicshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajayaraj.olympics.db.*;
import com.ajayaraj.olympicshop.service.Order;
import com.ajayaraj.olympicshop.service.ProductList;
import com.ajayaraj.olympicshop.service.User;

/**
 * Servlet implementation class DisplayOutOrderservlet
 */
@WebServlet("/DisplayOutOrderservlet")
public class DisplayOutOrderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayOutOrderservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ordernum = request.getParameter("ordernum");
		
		DatabaseBeanImpl getOrderDetails = new DatabaseBeanImpl();
		List<ProductList> custProductList = getOrderDetails.displayListProduct(ordernum);
		User customerDetail = getOrderDetails.getCustomer(ordernum);
		Order orderdetails = getOrderDetails.getOrderbyNum(ordernum);
		
		request.setAttribute("productList", custProductList);
		request.setAttribute("orderID", ordernum);
		request.setAttribute("customer", customerDetail);
		request.setAttribute("orderstatus", orderdetails);
		
		RequestDispatcher view = request.getRequestDispatcher("DisplayOutstand.jsp");
		view.forward(request, response);
		
	}

	
	
}
