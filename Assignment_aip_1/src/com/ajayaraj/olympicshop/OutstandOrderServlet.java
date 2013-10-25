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
 * Servlet implementation class OutstandOrderServlet
 */
@WebServlet("/OutstandOrderServlet")
public class OutstandOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutstandOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ordertype = request.getParameter("ordertype");
		
		DatabaseBeanImpl outstandOrder = new DatabaseBeanImpl();
		
		List<OutstandOrder> outStandList = outstandOrder.getOrderDetailList(ordertype);
		request.setAttribute("outstandList", outStandList);
		
		RequestDispatcher view = request.getRequestDispatcher("outstanding.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
