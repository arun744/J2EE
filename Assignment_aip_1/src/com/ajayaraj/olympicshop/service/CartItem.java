package com.ajayaraj.olympicshop.service;

public class CartItem {
     private Product product;
     private String productid;
     public int quantity = 0;
     
     public CartItem(Product product){
    	 this.product = product;
     }
     
     
    public String getDescription(){
    	return product.getDescription();
    }
    
    public double getUnitPrice(){
    	double price = Double.parseDouble(product.getPrice());
    	
    	return price;
    }
    
	public Product getProduct() {
		return product;
	}
	
	public String getCategory(){
		return product.getCategory();
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductid() {
		return product.getCode();
	}

	public void setProductid() {
		this.productid = product.getCode();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double totalPrice(){
		return getUnitPrice() * getQuantity();
	}
}
