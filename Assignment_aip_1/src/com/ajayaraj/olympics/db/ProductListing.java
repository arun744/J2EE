package com.ajayaraj.olympics.db;

import java.sql.*;
import java.util.*;

import com.ajayaraj.olympicshop.service.Product;

public class ProductListing {
   
	private ConnectDatabase connMyDB;
	private ResultSet productDataset;
	private int resultRecord;
	
	public ProductListing(){};
	
	public List<Product> viewProduct(int offSet, int noOfRecords, String category){
		List<Product> productList = new ArrayList<Product>();
		Product product = null;
		connMyDB = new ConnectDatabase();
		try {
			connMyDB.connect();
			productDataset = connMyDB.query(getQuery(category, offSet, noOfRecords));
			
			while(productDataset.next()){
				String code = productDataset.getString("productID");
				String categories = productDataset.getString("category");
				String description = productDataset.getString("decription");
				String price = productDataset.getString("price");	
				product = new Product(code, categories ,description, price);
				productList.add(product);
			}
			productDataset.close();
			
			productDataset = connMyDB.query("SELECT FOUND_ROWS()");
            if(productDataset.next())
                setResultRecord(productDataset.getInt(1));
			
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
		}finally
        {
            try {      
                if(connMyDB != null)
                	connMyDB.close();
                } catch (SQLException e) {
                e.printStackTrace();
            }
        }
     return productList;		
	}
	
	private String getQuery(String category, int offSet, int noOfRecords){
    String query = null;
		
		if (category != null)
			query = "select SQL_CALC_FOUND_ROWS * from producttbl where category = " + "'" + category  +"'"  + " limit "
	                + offSet + ", " + noOfRecords;
		else
			query = "select SQL_CALC_FOUND_ROWS * from producttbl  limit "
	                + offSet + ", " + noOfRecords;
		
		return query;
	}

	public int getResultRecord() {
		return resultRecord;
	}

	public void setResultRecord(int resultRecord) {
		this.resultRecord = resultRecord;
	}
}
