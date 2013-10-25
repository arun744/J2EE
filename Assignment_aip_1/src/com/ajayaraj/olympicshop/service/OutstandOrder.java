package com.ajayaraj.olympicshop.service;

public class OutstandOrder {
	
	
	private String orderID;
	private String country;
	private String postcode;
	private String status;
	private String lastName;
	private String amount;
	public OutstandOrder(String orderID, String lastName, String country, String postcode ,String amount, String status){
		setOrderID(orderID);
		setCountry(country);
		setLastName(lastName);
		setPostcode(postcode);
		setStatus(status);
		setAmount(amount);
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
