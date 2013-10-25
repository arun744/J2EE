package id11458724.dang.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cartId;
	private Date dateCreated;
	private List<Product> products;
	private double totalPrice;
	
	public Cart() {}
	
	/**
	 * @param cartId
	 * @param dateCreated
	 * @param products
	 * @param totalPrice
	 */
	public Cart(int cartId, Date dateCreated,
			double totalPrice) {
		this.cartId = cartId;
		this.dateCreated = dateCreated;
		this.totalPrice = totalPrice;
	}
	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}
	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
