package com.kaassa.business.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
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
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(email);
		dest.writeString(phone_one);
		dest.writeString(phone_two);
		dest.writeString(web_site);
	}
	
	
}
