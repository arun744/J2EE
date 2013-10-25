package com.ajayaraj.olympicshop.service;

import java.io.Serializable;

public class User implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5331112809129636674L;
	
	private String title;
	private String firstName;
	private String lastName;
	private String streetName;
	private String state;
	private String country;
	private String email;
	private String postcode;
	private String creditnum;
	
	
	


	public User(String title, String firstname, String lastname,String email ,String streetname, String state, String country, String postcode, String creditnum){
		setTitle(title);
		setFirstName(firstname);
		setLastName(lastname);
		setStreetName(streetname);
		setState(state);
		setCountry(country);
		setEmail(email);
		setPostcode(postcode);
		setCreditnum(creditnum);
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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

	public String getCreditnum() {
		return creditnum;
	}

	public void setCreditnum(String creditnum) {
		this.creditnum = creditnum;
	}
	

}
