package id11458724.dang.controller;

import id11458724.dang.model.Category;
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

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action == null) 
			action = "home";
		
		ShopDAO dao = new ShopDAOImpl();
		
		String address = "";
		
		// Redirect to home page
		if (action.equals("home")) {
			address = "home.jsp";
		} 
		// Redirect to new product page
		else if (action.equals("new-products")) {
			address = "new_products.jsp";
			browseNewProducts(request, dao);
		}
		// Redirect to the product page with the particular category
		else if (action.equals("products")) {
			address = "products.jsp";
			browseProducts(request, dao);
		} 
		// Redirect to the cart page
		else if (action.equals("cart")) {
			List<Product> products = (List<Product>)request.getSession().getAttribute("cart");
			if (products == null || products.isEmpty()) 
				address = "empty_cart.jsp";
			else {
				address = "cart.jsp";
				request.setAttribute("products", products);
			}
		// Redirect to the checkout page
		} else if (action.equals("checkout")) {
			address = "checkout.jsp";
		// Redirect to the confirm page
		} else if (action.equals("confirm")) {
			address = "confirm.jsp";
			Customer customer = (Customer)request.getSession().getAttribute("customer");
			
			// Validate customer info
			validateCustomerInfo(request, customer);
			
			request.setAttribute("customer", customer);
			
		} 
		// Redirect to the success page
		else if (action.equals("success")) {
			address = "success.jsp";
			String orderId = request.getParameter("orderId");
			request.setAttribute("orderId", orderId);
		}
		
		// Redirect to the search order page
		else if (action.equals("search")) {
			try {
				if (request.getParameter("found").equals("true")) {
					address = "search_result.jsp";
					request.setAttribute("products", request.getSession().getAttribute("products"));
					
					// Load order information
					Order order = (Order)request.getSession().getAttribute("order");
					order.setStatus(dao.searchOrder(order.getOrderId()).getStatus());
					request.setAttribute("order", order);
					
				} else
					address = "search_not_found.jsp";
			} catch (Exception e) {
				address = "search.jsp";
				request.getSession().removeAttribute("products");
				request.getSession().removeAttribute("order");
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
	// Browse to new product page
	private void browseNewProducts(HttpServletRequest request, ShopDAO dao) {
		List<Category> categories = dao.findAllCategory();
		List<Product> products = dao.findNewProducts();
		request.setAttribute("categories", categories);
		request.setAttribute("products", products);
	}
	
	// Browse product in particular category
	private void browseProducts(HttpServletRequest request, ShopDAO dao) {
		String categoryName = request.getParameter("category");
		List<Category> categories = dao.findAllCategory();
		List<Product> products = dao.findProductsByCategory(categoryName);
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("categories", categories);
		request.setAttribute("products", products);
	}
	
	// Validate customer info
	private void validateCustomerInfo(HttpServletRequest request, Customer customer) {
		if (!customer.isValid())
			request.setAttribute("error", "true");
		
		if (!customer.isValidGivenName())
			request.setAttribute("invalidGivenName", "Given Name must not be empty and number");
		if (!customer.isValidSurname())
			request.setAttribute("invalidSurname", "Surname must not be empty and number");
		if (!customer.isValidAddress())
			request.setAttribute("invalidAddress", "Address must not be empty and special character");
		if (!customer.isValidEmail())
			request.setAttribute("invalidEmail", "Email has an invalid email format");
		if (!customer.isValidCountry())
			request.setAttribute("invalidCountry", "Country name must not be empty and number");
		if (!customer.isValidState())
			request.setAttribute("invalidState", "State must not be empty and number");
		if (!customer.isValidPoscode())
			request.setAttribute("invalidPostCode", "Postcode must not be empty and characters");
		if (!customer.isValidCreditNo())
			request.setAttribute("invalidCreditNo", "Credit Number must not be empty and characters");
	}

}
