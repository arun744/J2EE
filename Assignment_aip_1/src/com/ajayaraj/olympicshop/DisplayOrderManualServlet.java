package com.ajayaraj.olympicshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajayaraj.olympics.db.DatabaseBeanImpl;
import com.ajayaraj.olympicshop.service.*;

/**
 * Servlet implementation class DisplayOrderManualServlet
 */
@WebServlet("/DisplayOrderManualServlet")
public class DisplayOrderManualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayOrderManualServlet() {
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
		
		RequestDispatcher view = request.getRequestDispatcher("manualOutstand.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
