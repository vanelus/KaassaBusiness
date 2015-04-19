package com.kaassa.business.models;

public class Location {
	
	String address;
	City city;
	Country country;
	
	 // setter
	public void setAddress(String address) { this.address = address; }
	public void setCity(City city) { this.city = city; }
	public void setCountry(Country country) { this.country = country; }	

	
	// getters
	public String getAddress() { return address; }
	public City getCity() { return city; }
	public Country getCountry() { return country; }

}
