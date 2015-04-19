package com.kaassa.business.models;

public class Contact {

	String email;
	String phone_one;
	String phone_two;
	String web_site;
	
	 // setter
	public void setEmail(String email) { this.email = email; }
	public void setPhoneOne(String phone_one) { this.phone_one = phone_one; }
	public void setPhoneTwo(String phone_two) { this.phone_two = phone_two; }	
	public void setWebSite(String web_site) { this.web_site = web_site; }	

	
	// getters
	public String getEmail() { return email; }
	public String getPhoneOne() { return phone_one; }
	public String getPhoneTwo() { return phone_two; }
	public String getWebSite() { return web_site; }
	
	
}
