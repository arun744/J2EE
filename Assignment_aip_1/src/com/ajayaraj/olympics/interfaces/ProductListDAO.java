package com.ajayaraj.olympics.interfaces;

import java.util.ArrayList;

import com.ajayaraj.olympicshop.service.*;

public interface ProductListDAO {
   
	public void addOrder(String orderID, ArrayList<CartItem> cartitem);
	public void addCartList(String orderid, User user, String status, double totalprice);
	public void addCustomer(User user);
	public Product displayProduct(String query);
	public void upateOrder(String orderID, String status);
	public ArrayList<ProductList> displayListProduct(String query);
	
}
