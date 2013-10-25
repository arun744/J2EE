package com.ajayaraj.olympicshop.service;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderCart implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1009431278479506357L;


/*	  public static void main(String[] arg){
    	ArrayList<CartItem> cartList = new ArrayList<CartItem>();

        Product product1 = new Product("1","add","add","add");
        Product product2 = new Product("1","add","add","add");

        addOrder(cartList,new CartItem(product1));
        addOrder(cartList, new CartItem(product2));
        

        for(CartItem items:cartList){
        	System.out.println(items.getDescription() + "," + items.getQuantity());
        }
        
        updateQuantity(cartList, 5 , "1");
        
        for(CartItem items:cartList){
        	System.out.println(items.getDescription() + "," + items.getQuantity());
        }
    }*/

	public void addOrder(ArrayList<CartItem> items, CartItem newitem ){
		int initailcount = 1;

		if(items.size()==0){
			newitem.setQuantity(initailcount);
			items.add(newitem);

		}
		else{
			if (checkexist(items, newitem)){
				for(int index = 0; index < items.size(); index++)
				{
					if (items.get(index).getProductid().equalsIgnoreCase(newitem.getProductid().trim()))
					{
						items.get(index).quantity++;
						return;  
					}
				}
			}
			else{
				newitem.setQuantity(initailcount);
				items.add(newitem);
			}
		}
	}


	public  boolean checkexist(ArrayList<CartItem> items, CartItem newitem ){

		boolean found = true;
		for(int index = 0; index < items.size(); index++)
			if (items.get(index).getProductid().equals(newitem.getProductid()))
				found = true;
			else
				found = false;	
		return found;	
	}



	public  void updateQuantity(ArrayList<CartItem> items, int quantity, String productid){
		
		if(quantity ==0){
			removeItem(items, productid);
			return;
		}
		
		for(CartItem existItem: items){
			if(existItem.getProductid().equals(productid))
				existItem.setQuantity(quantity);
			return;
		}
	}



	public  void removeItem (ArrayList<CartItem> items, String productid){

		for (int index = 0; index < items.size(); index++){

			if (items.get(index).getProductid().equals(productid)){
				items.remove(index);
				return;
			}
		}
	}

	public double getSubtotal(ArrayList<CartItem> items){
		double subtotal = 0;

		for(CartItem existItem: items)
			subtotal += existItem.totalPrice();

		return subtotal;
	}



}
