package com.kaassa.business.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Country implements Parcelable {
	
	String name_e_n;
	String name_f_r;
	String slug;
	
	 // setter
	public void setNameEn(String name_e_n) { this.name_e_n = name_e_n; }
	public void setNameFr(String name_f_r) { this.name_f_r = name_f_r; }
	public void setSlug(String slug) { this.slug = slug; }	

	
	// getters
	public String getNameEn() { return name_e_n; }
	public String getNameFr() { return name_f_r; }
	public String getSlug() { return slug; }
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
	    dest.writeString(name_e_n);
	    dest.writeString(name_f_r);
	    dest.writeString(slug);

	}
	
	public Country(Parcel in) 
	{
		name_e_n = in.readString();
		name_f_r = in.readString();
		slug = in.readString();
	}
	
	public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() 
	{
		  @Override
		  public Country createFromParcel(Parcel source) {
		    return new Country(source);
		  }

		  @Override
		  public Country[] newArray(int size) {
		    return new Country[size];
		  }
	};

}
