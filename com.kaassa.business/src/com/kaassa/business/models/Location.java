package com.kaassa.business.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
	
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
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Location(Parcel in) 
	{
		address = in.readString();
		city = in.readParcelable(City.class.getClassLoader());
		country = in.readParcelable(Country.class.getClassLoader());

	}
	
	public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() 
	{
		  @Override
		  public Location createFromParcel(Parcel source) {
		    return new Location(source);
		  }

		  @Override
		  public Location[] newArray(int size) {
		    return new Location[size];
		  }
	};
	
	@Override
	public void writeToParcel(Parcel dest, int flags) 
	{
		// TODO Auto-generated method stub
		
	    dest.writeString(address);
	    dest.writeParcelable(city, flags);
	    dest.writeParcelable(country, flags);
	}
	


}
