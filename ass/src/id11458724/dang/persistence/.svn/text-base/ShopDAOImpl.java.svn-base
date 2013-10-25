package id11458724.dang.persistence;

import id11458724.dang.model.Cart;
import id11458724.dang.model.Category;
import id11458724.dang.model.Customer;
import id11458724.dang.model.Order;
import id11458724.dang.model.Product;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class ShopDAOImpl implements ShopDAO {

	private DataSourceBean db;

	public ShopDAOImpl() {
		try {
			db = new DataSourceBean();
			// Retrieve data source name from weblogic server
			db.setDbDataSource("assignment");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Query the product
	private Vector<Product> queryProduct(String sql) {
		Vector<Product> products = new Vector<Product>();
		try {
			db.connect();
			ResultSet rs = db.query(sql);
			while (rs.next()) {
				int productId = rs.getInt(1);
				String categoryName = rs.getString(2);
				String desc = rs.getString(3);
				int quantity = 0;
				double price = 0.0;
				try {
					quantity = rs.getInt(4);
					price = rs.getDouble(5);
				} catch (Exception e) {
					price = rs.getDouble(4);
				}
				products.add(new Product(productId, categoryName, desc, quantity, price));
			}
			db.close();
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Query the cart
	private Vector<Cart> queryCart(String sql) {
		Vector<Cart> carts = new Vector<Cart>();
		try {
			db.connect();
			ResultSet rs = db.query(sql);
			while (rs.next()) {

				int cartId = rs.getInt(1);
				double totalPrice = rs.getDouble(2);
				Date dateCreated = rs.getDate(3);

				carts.add(new Cart(cartId, dateCreated, totalPrice));
			}
			db.close();
			return carts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Query the customer
	private Vector<Customer> queryCustomer(String sql) {
		Vector<Customer> customers = new Vector<Customer>();
		try {
			db.connect();
			ResultSet rs = db.query(sql);
			while (rs.next()) {
				int customerId = rs.getInt(1);
				String title = rs.getString(2);
				String givenName = rs.getString(3);
				String surname = rs.getString(4);
				String email = rs.getString(5);
				String address = rs.getString(6);
				String country = rs.getString(7);
				String state = rs.getString(8);
				String postcode = rs.getString(9);
				String creditNo = rs.getString(10);

				customers.add(new Customer(customerId, title, givenName,
						surname, email, address, country, state, postcode,
						creditNo));
			}
			db.close();
			return customers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Query the category
	private Vector<Category> queryCategory(String sql) {
		Vector<Category> categories = new Vector<Category>();
		try {
			db.connect();
			ResultSet rs = db.query(sql);
			while (rs.next()) {
				int categoryId = rs.getInt(1);
				String categoryName = rs.getString(2);
				categories.add(new Category(categoryId, categoryName));
			}
			db.close();
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// Query the order
	private Vector<Order> queryOrder(String sql) {
		Vector<Order> orders = new Vector<Order>();
		try {
			db.connect();
			ResultSet rs = db.query(sql);
			while (rs.next()) {
				String orderId = rs.getString(1);
				int customerId = rs.getInt(2);
				int cartId = rs.getInt(3);
				String status = rs.getString(4);

				orders.add(new Order(orderId, customerId, cartId, status));
			}
			db.close();
			return orders;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// Execute the INSERT, DELETE, UPDATE sql
	private void update(String sql) {
		try {
			db.connect();
			db.update(sql);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Find all category
	@Override
	public List<Category> findAllCategory() {
		String sql = "SELECT * FROM Category";
		return queryCategory(sql);
	}

	// Find the newest added product
	@Override
	public List<Product> findNewProducts() {
		String sql = "SELECT productID, categoryName, Description, Price " +
					 "FROM Product, category "  +
					 "WHERE Product.CategoryID = Category.CategoryID " +
					 "ORDER BY ProductID DESC LIMIT 6";
		return queryProduct(sql);
	}

	// Find product by category
	@Override
	public List<Product> findProductsByCategory(String categoryName) {
		String sql = "SELECT productID, categoryName, Description, Price " +
					 "FROM Product, Category " + 
				   	 "WHERE Product.CategoryID = Category.CategoryID " +
				   	 "AND CategoryName = '" + categoryName + "' " +
				   	 "ORDER BY ProductID DESC";
		return queryProduct(sql);
	}

	// Find particular product
	@Override
	public Product findProduct(int productId) {

		String sql = "SELECT productID, categoryName, Description, Price " +
					 "FROM Product, Category " + 
					 "WHERE category.categoryID = product.categoryID " + 
					 "AND ProductID = " + productId;
		return queryProduct(sql).get(0);
	}

	// Find particular category
	@Override
	public Category findCategory(int categoryId) {
		String sql = "SELECT * FROM Category " + "WHERE CategoryID = "
				+ categoryId;
		return queryCategory(sql).get(0);
	}

	// Add customer
	@Override
	public void add(Customer customer) {
		String title = customer.getTitle();
		String givenName = customer.getGivenName();
		String surname = customer.getSurname();
		String email = customer.getEmail();
		String address = customer.getAddress();
		String country = customer.getCountry();
		String state = customer.getState();
		String postcode = customer.getPostcode();
		String creditNo = customer.getCreditNo();
		String sql = "INSERT INTO Customer VALUES(NULL, '" + title + "', '"
				+ givenName + "', " + "'" + surname + "', '" + email + "', '"
				+ address + "', " + "'" + country + "', '" + state + "', '"
				+ postcode + "', '" + creditNo + "')";
		update(sql);
	}

	// Add cart
	@Override
	public void add(Cart cart) {
		// Create the cart record in table cart
		String addCart = "INSERT INTO Cart VALUES(NULL, "
				+ cart.getTotalPrice() + ", NOW())";
		update(addCart);

		// Get the recent cartId
		String selectCart = "SELECT * FROM Cart ORDER BY CartId DESC LIMIT 1";
		int cartId = queryCart(selectCart).get(0).getCartId();
		cart.setCartId(cartId);

		// Add the info cart into product_cart table
		for (Product product : cart.getProducts()) {
			int productID = product.getProductId();
			int quantity = product.getQuantity();
			String addProduct = "INSERT INTO Cart_Product VALUES(" + cartId
					+ ", " + productID + ", " + quantity + ")";
			update(addProduct);
		}
	}

	@Override
	public Customer findRecentCustomer() {
		String sql = "SELECT * FROM Customer ORDER BY CustomerId DESC LIMIT 1";
		return queryCustomer(sql).get(0);
	}

	@Override
	public Cart findRecentCart() {
		String sql = "SELECT * FROM Cart ORDER BY CartId DESC LIMIT 1";
		return queryCart(sql).get(0);
	}

	@Override
	public Order findRecentOrder() {
		String sql = "SELECT * FROM purchase ORDER BY PurchaseID DESC LIMIT 1";
		try {
			return queryOrder(sql).get(0);
		} catch (Exception e) {
			return null;
		}
	}

	// Add order
	@Override
	public void add(Order order) {
		String sql = "INSERT INTO Purchase VALUES('" + order.getOrderId()
				+ "', " + order.getCustomerId() + ", " + order.getCartId()
				+ ", '" + order.getStatus() + "')";
		update(sql);
	}

	// Search product by customer surname and order number
	@Override
	public List<Product> searchProductsByCart(int cartId) {
		String sql = "SELECT product.productid, categoryname, description, quantity, price " +
					 "FROM cart_product, product, category " +
					 "WHERE product.productid = cart_product.productid " + 
					 "AND product.categoryid = category.categoryid " +
					 "AND cartid = "+ cartId;
		try {
			return queryProduct(sql);
		} catch (Exception e) {
			return null;
		}
	}
	
	// Search order
	@Override
	public Order searchOrder(String orderNo, String customerSurname) {
		String sql = "SELECT purchaseid, customer.customerid, cartid, status " +
					 "FROM Purchase, Customer " +
					 "WHERE purchase.customerid = customer.customerid " +
					 "AND purchaseId = '"+ orderNo +"' " +
					 "AND surname = '"+ customerSurname +"'";
		try {
			return queryOrder(sql).get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	// Find all order
	@Override
	public List<Order> findAllOrder() {
		String sql = "SELECT * FROM purchase";
		return queryOrder(sql);
	}

	// Find all product
	@Override
	public List<Product> findAllProduct() {
		String sql = "SELECT productID, categoryName, Description, Price " +
				 	 "FROM Product, category "  +
				 	 "WHERE Product.CategoryID = Category.CategoryID ";
		return queryProduct(sql);
	}

	// Find all customer
	@Override
	public List<Customer> findAllCustomer() {
		String sql = "SELECT * FROM Customer";
		return queryCustomer(sql);
	}

	// find all cart
	@Override
	public List<Cart> findAllCart() {
		String sql = "SELECT * FROM cart";
		return queryCart(sql);
	}
	
	// Find particular customer
	@Override
	public Customer findCustomer(int customerId) {
		String sql = "SELECT * FROM Customer WHERE customerID = " + customerId;
		try {
			return queryCustomer(sql).get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	// Update status order
	@Override
	public void updateOrder(String orderId, String status) {
		String sql = "UPDATE Purchase SET status = '"+ status +"' WHERE PurchaseID = '"+ orderId +"'";
		update(sql);
	}
	
	// Search order by order number
	@Override
	public Order searchOrder(String orderNo) {
		String sql = "SELECT * FROM purchase WHERE purchaseid = '" + orderNo + "'";
		try {
			return queryOrder(sql).get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	// Find outstanding orders
	@Override
	public List<Order> findOutstandingOrder() {
		String sql = "SELECT * FROM purchase WHERE Status = 'ORDERED' OR Status = 'PAID'";
		return queryOrder(sql);
	}
	
	// Find customers with outstanding purchase status
	@Override
	public Customer findOutstandingCustomer(String purchaseId) {
		String sql = "SELECT * FROM Customer, Purchase " +
					 "WHERE customer.customerid = purchase.customerid " +
					 "AND purchaseid = '"+ purchaseId +"'";
		return queryCustomer(sql).get(0);
	}
		
	// Find carts with outstanding purchase status
	@Override
	public Cart findOutstandingCart(String purchaseId) {
		String sql = "SELECT * FROM Cart, Purchase " +
				 "WHERE cart.cartid = purchase.cartid " +
				 "AND purchaseid = '"+ purchaseId +"'";
		return queryCart(sql).get(0);
	}
}
