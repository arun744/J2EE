package com.ajayaraj.olympics.db;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

import com.ajayaraj.olympicshop.service.Product;

public class DisplayProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3596359639388778099L;
    private ConnectDatabase connDB;
    private ResultSet productSet;
	public DisplayProduct(){};
	
	
	
	public Product getproduct(String productid){
		   List <Product> items = new ArrayList<Product>();
		   
		   Product product = null;
		   connDB = new ConnectDatabase();
		   String sqlquery = "select * from producttbl where productid= "+ productid +" ;";
			   try {
				connDB.connect();
				productSet = connDB.query(sqlquery);
				
				while(productSet.next()){
					String code = productSet.getString("productID");
					String categories = productSet.getString("category");
					String description = productSet.getString("decription");
					String price = productSet.getString("price");	
					product = new Product(code, categories ,description, price);
					return product;
				}
				connDB.close();
				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return product;   
	}
}
