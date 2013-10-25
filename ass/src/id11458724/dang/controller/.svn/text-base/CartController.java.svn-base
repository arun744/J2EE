package id11458724.dang.controller;

import id11458724.dang.model.Product;
import id11458724.dang.persistence.ShopDAO;
import id11458724.dang.persistence.ShopDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Product> products;
       
    public CartController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get the session cart
		HttpSession session = request.getSession();
		products = (ArrayList<Product>)session.getAttribute("cart");
		
		String action = request.getParameter("action");
		
		if (action.equals("add")) {
			addCart(request);
		} else if (action.equals("update")) {
			updateCart(request);
		} else if (action.equals("delete")) {
			deleteCart(request);
		} else if (action.equals("cancel")) {
			products.clear();
		}
		
		// Assign the session cart
		session.setAttribute("cart", products);

		response.sendRedirect("shop?action=cart");
	}
	
	// delete product in cart 
	private void deleteCart(HttpServletRequest request) {
		// Get product id request
		int id = Integer.parseInt(request.getParameter("productId"));
		// Iterate the products list to remove the request deleted product
		for(Product product : products) { 
			if(product.getProductId() == id) {
				products.remove(product);
				break;
			}
		}
		
		// After removing if there is no product remaining
		if (products.isEmpty()) 
			products.clear(); // clear the cart
	}
	
	// Add cart
	private void addCart(HttpServletRequest request) {
		// Get product id request
		int id = Integer.parseInt(request.getParameter("productId"));
		
		if (products == null) {
			products = new ArrayList<Product>();
			addCart(products, id);
		} else {
			// If the product already in the cart
			Product product = isDuplicated(products, id);
			if(product != null)
				product.setQuantity(product.getQuantity() + 1); // Increase product quantity by 1
			else
				addCart(products, id);
		}
	}
	
	// Update cart
	private void updateCart(HttpServletRequest request) {
		// First time check the session after updating quantity
		// remove all the zero quantity products
		if (products != null) 
			products.removeAll(emptyProducts(request, products));
		
		// After remove all the empty products
		// If the session has zero element
		if (products.isEmpty())
			products.clear(); // clear the cart
		else
			updateQuantity(request, products); // update the session
	}
	
	// Remove the product which is empty quantity
	private ArrayList<Product> emptyProducts(HttpServletRequest request, ArrayList<Product> products) {
		ArrayList<Product> emptyProducts = new ArrayList<Product>();
		for(Product product : products) { 
			// The name of the each text input quantity in the form is the productId that follow the order of the existing session products
			// By iterating the products list, we can get the value for each text input
			// The input could be ['orderid=1', '1'], ['orderid=2', '3']
			// see the cart.jsp
			int quantity = getNewQuantity(request, product);
			
			// If the new quantity < 0 then add those of negative products into new list in order to remove them later
			if(quantity <= 0)
				emptyProducts.add(product);
		}
		
		return emptyProducts;
	}
	
	// Update new quantity for each product
	private void updateQuantity(HttpServletRequest request, ArrayList<Product> products) {
		for(Product product : products) { 
			// The name of the each text input quantity in the form is the productId that follow the order of the existing session products
			// By iterating the products list, we can get the value for each text input
			// The input could be ['orderid=1', '1'], ['orderid=2', '3']
			// see the cart.jsp
			int quantity = getNewQuantity(request, product);
			product.setQuantity(quantity);
		}
	}
	
	// Get updated quantity from the cart
	private int getNewQuantity(HttpServletRequest request, Product product) {
		try {
			// Convert id to String because getParameter accepts only String
			return Integer.parseInt(request.getParameter(String.valueOf(product.getProductId())));
		} catch (Exception e) {
			// If the input is alpha character
			// Keep the original quantity
			return product.getQuantity();
		}
	}
	
	// Is the product exist in the session cart
	private Product isDuplicated(List<Product> products, int id) {
		for(Product product : products) {
			if(product.getProductId() == id)
				return product;
		}
		return null;
	}

	// Add product into session cart
	private void addCart(ArrayList<Product> products, int id) {
		ShopDAO dao = new ShopDAOImpl();
		int quantity = 1; // The first quantity is 1
		Product product = dao.findProduct(id);
		
		// Set quantity, category name for the first time added into cart
		product.setQuantity(quantity);
		products.add(product);
	}
}
