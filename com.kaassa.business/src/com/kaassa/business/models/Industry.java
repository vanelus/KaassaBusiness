package com.kaassa.business.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Industry implements Parcelable {

	String name_e_n;
	String name_f_r;
	String slug;
	int count_companies;
	
	 // setter
	public void setNameEn(String name_e_n) { this.name_e_n = name_e_n; }
	public void setNameFr(String name_f_r) { this.name_f_r = name_f_r; }
	public void setSlug(String slug) { this.slug = slug; }	
	public void setCountCompanies(int count_companies) { this.count_companies = count_companies; }	

	
	// getters
	public String getNameEn() { return name_e_n; }
	public String getNameFr() { return name_f_r; }
	public String getSlug() { return slug; }
	public int getCountCompanies() { return count_companies; }
	
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
	    dest.writeInt(count_companies);
	}
	
	public Industry(Parcel in) 
	{
		name_e_n = in.readString();
		name_f_r = in.readString();
		slug = in.readString();
		count_companies = in.readInt();

	}
	
	public static final Parcelable.Creator<Industry> CREATOR = new Parcelable.Creator<Industry>() 
	{
		  @Override
		  public Industry createFromParcel(Parcel source) {
		    return new Industry(source);
		  }

		  @Override
		  public Industry[] newArray(int size) {
		    return new Industry[size];
		  }
	};
	
}
