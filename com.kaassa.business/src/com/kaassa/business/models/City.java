package com.kaassa.business.models;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {

	String name;
	String slug;
	
	 // setter
	public void setName(String name_f_r) { this.name = name; }
	public void setSlug(String slug) { this.slug = slug; }	

	
	// getters
	public String getName() { return name; }
	public String getSlug() { return slug; }
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
	    dest.writeString(name);
	    dest.writeString(slug);
	}
	
	public City(Parcel in) 
	{
		name = in.readString();
		slug = in.readString();

	}
	
	public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() 
	{
		  @Override
		  public City createFromParcel(Parcel source) {
		    return new City(source);
		  }

		  @Override
		  public City[] newArray(int size) {
		    return new City[size];
		  }
	};
}
