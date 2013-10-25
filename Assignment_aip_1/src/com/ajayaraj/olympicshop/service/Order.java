package com.ajayaraj.olympicshop.service;

public class Order {
   
	
	private String orderID;
	private String status;
	private String totalprice;
	private int customerID;
	public Order(String orderID, String status, String totalprice){
		setOrderID(orderID);
		setStatus(status);
		setTotalprice(totalprice);
	
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
}
