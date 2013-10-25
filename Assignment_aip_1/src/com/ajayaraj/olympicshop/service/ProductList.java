package com.ajayaraj.olympicshop.service;

public class ProductList {
	
	private String orderid;
	private String productid;
	private String description;
	private String totalcost;
	private String quantity;
	private String category;
	
	public ProductList(String orderid, String productid, String category ,String description, String totalcost, String quantity){
		   setOrderid(orderid);
		   setProductid(productid);
		   setDescription(description);
		   setTotalcost(totalcost);
		   setQuantity(quantity);
		   setCategory(category);
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
