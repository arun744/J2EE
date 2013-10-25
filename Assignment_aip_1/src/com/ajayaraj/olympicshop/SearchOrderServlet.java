package com.ajayaraj.olympicshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajayaraj.olympics.db.DatabaseBeanImpl;
import com.ajayaraj.olympicshop.service.Order;
import com.ajayaraj.olympicshop.service.ProductList;

/**
 * Servlet implementation class SearchOrderServlet
 */
@WebServlet("/SearchOrderServlet")
public class SearchOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("orderid");
		String surname = request.getParameter("surname");
		Order order;
		
		DatabaseBeanImpl getDetails = new DatabaseBeanImpl();
		List<ProductList> orderList = getDetails.displayListProduct(orderid);
		order = getDetails.getOrderDetail(orderid, surname);
		
		request.setAttribute("viewList", orderList);
		request.setAttribute("orderview", order);
		
		RequestDispatcher view = request.getRequestDispatcher("displayOrder.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
