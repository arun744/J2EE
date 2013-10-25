package id11458724.dang.persistence;

import id11458724.dang.model.Cart;
import id11458724.dang.model.Category;
import id11458724.dang.model.Customer;
import id11458724.dang.model.Order;
import id11458724.dang.model.Product;

import java.util.List;

public interface ShopDAO {
	// Add order
	public void add(Order order);
	
	// Add cart
	public void add(Cart cart);
	
	// Add customer
	public void add(Customer customer);
	
	// Update status order
	public void updateOrder(String orderId, String status);
	
	// Find all category
	public List<Category> findAllCategory();
	
	// Find the newest added product
	public List<Product> findNewProducts();
	
	// Find the products by category
	public List<Product> findProductsByCategory(String categoryName);
	
	// Find particular product
	public Product findProduct(int productId);
	
	// Find particular category 
	public Category findCategory(int categoryId);
	
	// Find particular customer
	public Customer findCustomer(int customerId);
	
	// Find recent customer
	public Customer findRecentCustomer();
	
	// Find recent cart
	public Cart findRecentCart();
	
	// Find recent order
	public Order findRecentOrder();
	
	// Find all order
	public List<Order> findAllOrder();
	
	// Find outstanding orders
	public List<Order> findOutstandingOrder();
	
	// Find all product
	public List<Product> findAllProduct();
	
	// Find all customer
	public List<Customer> findAllCustomer();
	
	// Find all cart
	public List<Cart> findAllCart();
	
	// Search products by cart
	public List<Product> searchProductsByCart(int cartId);
	
	// Search order by order number and customer surname
	public Order searchOrder(String orderNo, String customerSurname);
	
	// Search order by order number
	public Order searchOrder(String orderNo);
	
	// Find customer with outstanding purchase status
	public Customer findOutstandingCustomer(String purchaseId);
	
	// Find cart with outstanding purchase status
	public Cart findOutstandingCart(String purchaseId);

}
