package com.kaassa.business.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Picture implements Parcelable {

	int id;
	String ext;
	String alt;
	
	 // setter
	public void setId(int count_companies) { this.id = id; }	
	public void setExt(String ext) { this.ext = ext; }
	public void setAlt(String alt) { this.alt = alt; }

	
	// getters
	public int getId() { return id; }
	public String getExt() { return ext; }
	public String getAlt() { return alt; }
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	    dest.writeInt(id);
	    dest.writeString(ext);
	    dest.writeString(alt);
	}
	
	public Picture(Parcel in) 
	{
		id = in.readInt();
		ext = in.readString();
		alt = in.readString();
		
	}
	
	public static final Parcelable.Creator<Picture> CREATOR = new Parcelable.Creator<Picture>() 
	{
		  @Override
		  public Picture createFromParcel(Parcel source) {
		    return new Picture(source);
		  }

		  @Override
		  public Picture[] newArray(int size) {
		    return new Picture[size];
		  }
	};
	
}
