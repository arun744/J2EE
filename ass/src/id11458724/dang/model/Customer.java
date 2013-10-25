package id11458724.dang.model;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int customerId;
	private String title;
	private String givenName;
	private String surname;
	private String email;
	private String address;
	private String country;
	private String state; 
	private String postcode;
	private String creditNo;

	/**
	 * @param customerId
	 * @param title
	 * @param givenName
	 * @param surname
	 * @param email
	 * @param address
	 * @param country
	 * @param state
	 * @param postcode
	 * @param creditNo
	 */
	public Customer(int customerId, String title, String givenName, String surname,
			String email, String address, String country, String state,
			String postcode, String creditNo) {
		this.customerId = customerId;
		this.title = title;
		this.givenName = givenName;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.country = country;
		this.state = state;
		this.postcode = postcode;
		this.creditNo = creditNo;
	}
	
	/**
	 * @param title
	 * @param givenName
	 * @param surname
	 * @param email
	 * @param address
	 * @param country
	 * @param state
	 * @param postcode
	 * @param creditNo
	 */
	public Customer(String title, String givenName, String surname,
			String email, String address, String country, String state,
			String postcode, String creditNo) {
		this.title = title;
		this.givenName = givenName;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.country = country;
		this.state = state;
		this.postcode = postcode;
		this.creditNo = creditNo;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}
	/**
	 * @param givenName the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * @return the creditNo
	 */
	public String getCreditNo() {
		return creditNo;
	}
	/**
	 * @param creditNo the creditNo to set
	 */
	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}
	
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public boolean isValidGivenName() {
		return Pattern.matches("[A-Za-z]+", givenName);
	}
	public boolean isValidSurname() {
		return Pattern.matches("[A-Za-z]+", surname);
	}
	public boolean isValidEmail() {
		return Pattern.matches("[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})", email);
	}
	public boolean isValidAddress() {
		return Pattern.matches("[A-Za-z0-9 ]+", address);
	}
	public boolean isValidCountry() {
		return Pattern.matches("[A-Za-z]+", country);
	}
	public boolean isValidState() {
		return Pattern.matches("[A-Za-z]+", state);
	}
	public boolean isValidPoscode() {
		return Pattern.matches("[0-9]+", postcode);
	}
	public boolean isValidCreditNo() {
		return Pattern.matches("[0-9]+", creditNo);
	}
	
	public boolean isValid() {
		return isValidGivenName() && isValidSurname() && isValidAddress() && isValidEmail()
				&& isValidAddress() && isValidCountry() && isValidState() && isValidPoscode() && isValidCreditNo();
	}

	@Override
	public String toString() {
		return "Customer [givenName=" + givenName + ", surname=" + surname
				+ ", email=" + email + ", address=" + address + ", country="
				+ country + ", state=" + state + ", postcode=" + postcode
				+ ", creditNo=" + creditNo + "]";
	}

}
