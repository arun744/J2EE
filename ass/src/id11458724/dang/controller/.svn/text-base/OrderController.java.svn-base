package id11458724.dang.controller;

import id11458724.dang.model.Cart;
import id11458724.dang.model.Customer;
import id11458724.dang.model.Order;
import id11458724.dang.model.Product;
import id11458724.dang.persistence.ShopDAO;
import id11458724.dang.persistence.ShopDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		ShopDAO dao = new ShopDAOImpl();
		
		if (action.equals("confirm")) {
			initCustomerSession(request);
			response.sendRedirect("shop?action=confirm");
		} else if (action.equals("proceed")) {
			// Save customer info
			saveCustomer(request, dao);
			
			// Save cart info
			saveCart(request, dao);
			
			// Save order info
			Customer customer = dao.findRecentCustomer();
			Order order = dao.findRecentOrder();
			Cart cart = dao.findRecentCart();
			
			// If this is the first order
			if (order == null) {
				order = new Order();
				order.setOrderId("huydang0001"); // Hard code the first order id
				order.setCustomerId(customer.getCustomerId());
				order.setCartId(cart.getCartId());
				order.setStatus("ORDERED");
			} else {
				
				order.setOrderId(orderId(order)); // Create the order id format huydangnnnn
				order.setCustomerId(customer.getCustomerId());
				order.setCartId(cart.getCartId());
				order.setStatus("ORDERED");
			}
			dao.add(order);
			response.sendRedirect("shop?action=success&orderId=" + order.getOrderId());
			
		} else if (action.equals("search")) {
			String orderNo = request.getParameter("orderNo");
			String surname = request.getParameter("surname");
			
			Order order = dao.searchOrder(orderNo, surname);
			if (order != null) {
				
				List<Product> products = dao.searchProductsByCart(order.getCartId());

				request.getSession().setAttribute("products", products);
				request.getSession().setAttribute("order", order);
			
				response.sendRedirect("shop?action=search&found=true");
			} else 
				response.sendRedirect("shop?action=search&found=false");
		}
	}
	
	private void saveCustomer(HttpServletRequest request, ShopDAO dao) {
		Customer customer = (Customer)request.getSession().getAttribute("customer");
		dao.add(customer);
		request.getSession().removeAttribute("customer");
	}
	
	private void saveCart(HttpServletRequest request, ShopDAO dao) {
		ArrayList<Product> products = (ArrayList<Product>)request.getSession().getAttribute("cart");
		Cart cart = new Cart();
		cart.setProducts(products);
		cart.setTotalPrice(totalPrice(products));
		dao.add(cart);
		request.getSession().removeAttribute("cart");
	}
	
	// Create a session customer information
	private void initCustomerSession(HttpServletRequest request) {
		
		if (request.getSession().getAttribute("customer") != null)
			request.getSession().removeAttribute("customer");
			
		String title = request.getParameter("title");
		String givenName = request.getParameter("givenName");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String addr = request.getParameter("address");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String postcode = request.getParameter("postcode");
		String creditNo = request.getParameter("creditNo");
	
		request.getSession().setAttribute("customer", new Customer(title, givenName, surname,email, 
											addr, country, state, postcode, creditNo));
	}
	
	// Generate suffix id number following the format nnnn
	private String suffix(int id) {
		id++;
		if (id < 10)
			return "000" + id;
		else if (id < 100)
			return "00" + id;
		else if (id < 1000)
			return "0" + id;
		else 
			return String.valueOf(id);
	}
	
	// Create the order id format huydangnnnn
	private String orderId(Order order) {
		String prefix = "huydang";
		// Retrieve the last order id from database then substring it to get the 4 last digit
		// convert it to number then check condition to add the correct 0 number by calling method suffix()
		String suffix = suffix(Integer.parseInt(order.getOrderId().substring(7)));
		return prefix + suffix;
	}
	
	// Get cart total price for the order
	private double totalPrice(ArrayList<Product> products) {
		double totalPrice = 0.0;
		
		for(Product product : products) {
			totalPrice += (product.getQuantity() * product.getPrice());
		}
		
		return totalPrice;
	}
}
