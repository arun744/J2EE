package com.ajayaraj.olympicshop.service;

import java.io.Serializable;

public class UserValidation implements Serializable {

	/**
	 * Check for validation user information it a business service,
	 * Checking for names, address and email.
	 */
	private static final long serialVersionUID = 6411562245742520022L;
	
	public boolean validateName(String name){
		
		boolean check = false;
		
		if(name.isEmpty())
		   check = true ;
		
	    if (!(name.matches("^[A-Z]'?[- a-zA-Z]+$")))
	       check = true;
		return check;
	}
	

	
	public boolean validateEmail(String email){
		
		boolean check = false;
		if (email.length()==0){
			check = true;
		}
		
		 if(!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$"))
		{
			check = true;
		}
		return check;
	}
	
	public boolean validateAddress(String addressname){
		
		boolean check = false;
		if (addressname.isEmpty()){
			check = true;
		}
		
		if(!addressname.matches("^\\d{1,5}?[ /]?\\d{1,5}?\\s[A-Za-z.]+\\s[A-Za-z.]{2,7}$")){
			check = true;
		}
		
		return check;
			
	}
	
 public boolean validatePost(String addressname){
		
		boolean check = false;
		if (addressname.isEmpty()){
			check = true;
		}
		
		if(!addressname.matches("^\\d{1,4}$")){
			check = true;
		}
		
		return check;
			
	}
	
	public boolean validateState(String name ){
        boolean check = false;
		
		if(name.isEmpty())
		   check = true ;
		
	    if (!(name.matches("^[A-Z]'?[- a-zA-Z]+$")))
	       check = true;
		return check;
	}
	
	public boolean validateCountry(String name ){
        boolean check = false;
		
		if(name.isEmpty())
		   check = true ;
		
	    if (!(name.matches("^[A-Z]'?[- a-zA-Z]+$")))
	       check = true;
		return check;
	}
	
	public boolean validateCredit(String name){
		boolean check = false;
		
		if(name.isEmpty())
			check = true;
		
		if(!(name.matches("^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$")))
			check = true;
		
		return check;
	}
	
	
	
	

}
