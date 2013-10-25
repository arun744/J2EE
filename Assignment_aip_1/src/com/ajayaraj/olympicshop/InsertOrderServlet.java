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

import com.ajayaraj.olympics.db.DatabaseBeanImpl;
import com.ajayaraj.olympicshop.service.CartItem;
import com.ajayaraj.olympicshop.service.User;

/**
 * Servlet implementation class InsertOrderServlet
 */
@WebServlet("/InsertOrderServlet")
public class InsertOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STATUS = "ORDERED";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    HttpSession session = request.getSession(false);
		    DatabaseBeanImpl insertDBvalues = new DatabaseBeanImpl();
		    double totalprice = Double.parseDouble((String)session.getAttribute("totalprice"));
			ArrayList<CartItem> existingList = (ArrayList<CartItem>)session.getAttribute("orderList");
			User customerdata = (User)session.getAttribute("uservalue");
			
			String orderID = generateOrderNum();
			insertDBvalues.addCartList(orderID, customerdata, STATUS, totalprice);
			insertDBvalues.addOrder(orderID, existingList);
			
			if(session != null){
			session.invalidate();
			}
			session = request.getSession(true);
		    //response.sendRedirect("index.jsp");
		    
		    RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
	}
	
	
	public String generateOrderNum(){
		DatabaseBeanImpl getorderid = new DatabaseBeanImpl();
		String dbOrderID = getorderid.orderAutoNum();
		String autonum;
		if(dbOrderID == null){
		   autonum = "ajayaraj0001";
		}
		else{
		   int number = getnumber(dbOrderID);
		   String letters = getAlpha(dbOrderID);
		   
		   int increment = number + 1;
		   String formatValue = String.format("%04d", increment);
		   autonum = letters.concat(String.valueOf(formatValue));
		}
		return autonum;
	}
	
	public int getnumber(String orderid){
		int digits = Integer.parseInt(orderid.substring(8, orderid.length()));
		return digits;
	}
	
	public String getAlpha(String orderid){
		String alpha = orderid.substring(0,8);
		return alpha;
	}

}
