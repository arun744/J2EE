package id11458724.dang.controller;

import id11458724.dang.model.Customer;
import id11458724.dang.model.Order;
import id11458724.dang.model.Product;
import id11458724.dang.persistence.ShopDAO;
import id11458724.dang.persistence.ShopDAOImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action == null) 
			action = "admin";
		
		String address = "";
		
		ShopDAO dao = new ShopDAOImpl();
		
		// Redirect to admin page
		if (action.equals("admin")) {
			address = "admin.jsp";
			
			// List all information about outstanding order
			List<Order> orders = dao.findOutstandingOrder();
			
			// set outstanding customer and cart for each order
			for (Order order : orders) {
				order.setCustomer(dao.findOutstandingCustomer(order.getOrderId()));
				order.setCart(dao.findOutstandingCart(order.getOrderId()));
			}
			
			request.setAttribute("orders", orders);
		} 
		// Redirect to select order page
		else if (action.equals("select")) {
			
			address = "select.jsp";
			
			// get request orderid and customerid
			String orderNo = request.getParameter("orderId");
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			
			setErrorMSg(request);
			
			// fetch customer info
			Customer customer = dao.findCustomer(customerId);
			
			// fetch order and products inside the order
			Order order = dao.searchOrder(orderNo, customer.getSurname());
			List<Product> products = dao.searchProductsByCart(order.getCartId());

			// send respone back to select page
			request.setAttribute("products", products);
			request.setAttribute("order", order);
			request.setAttribute("customer", customer);
			
		} 
		// Update the status order then reload page
		else if (action.equals("update")) {
			
			String status = request.getParameter("status").toUpperCase();
			String orderId = request.getParameter("orderId");
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			
			// Validate status code
			if (isValidatedStatusCode(status)) {	
				// Update order
				dao.updateOrder(orderId, status);
				address = "admin?action=select&orderId="+ orderId +"&customerId=" + customerId;
			} else {
				address = "admin?action=select&error=true&orderId="+ orderId +"&customerId=" + customerId;
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
	// get validation request to send error msg
	private void setErrorMSg(HttpServletRequest request) {
		
		if (request.getParameter("error") != null) {
			String error = request.getParameter("error");
			if (error.equals("true")) {
				String msg = "The status code are validated only with ORDERED or PAID or SENT";
				request.setAttribute("msg", msg);
			}
		}
	}
	
	// Validate status code
	private boolean isValidatedStatusCode(String status) {
		return (status.equalsIgnoreCase("paid") || status.equalsIgnoreCase("ordered") || status.equalsIgnoreCase("sent"));
	}
}
