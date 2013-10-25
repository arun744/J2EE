package com.ajayaraj.olympicshop.service;

import java.io.Serializable;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4633010376972080572L;
	private String code;
	private String category;
	private String description;
	private String price;
	
	public Product(String code, String category, String description, String price){
		setCode(code);
		setCategory(category);
		setDescription(description);
		setPrice(price);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
