package com.kaassa.business.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Company implements Parcelable {
	
	  	String name;
	  	String slug;
	  	Location location;
	  	Contact contact;
	  	int foundation;
	  	String slogan;
	  	List<Picture> pictures;
	  	Industry industry;
	  	@SerializedName("children")
	  	List<Company> subsidiaries;
	  	List<Executive> executives;
	  	@SerializedName("count_executives")
	  	int countExecutives;
	  	String parentCompanySlug;
	  	
	  	
	    // constructors
		public Company(String name,String slug,Location location,Contact contact,int foundation,String slogan,List<Picture> pictures,Industry industry,List<Company> subsidiaries,List<Executive> executives,int countExecutives, String parentCompanySlug) {
			this.name = name;
			this.slug = slug;
			this.location = location;
			this.contact = contact;
			this.foundation = foundation;
			this.slogan = slogan;	
			this.pictures = pictures;
			this.industry = industry;
			this.subsidiaries = subsidiaries;
			this.executives = executives;
			this.countExecutives = countExecutives;	
			this.parentCompanySlug = parentCompanySlug;		

		}
		
		public Company() {
			this.name = "";
			this.slug = "";
			this.location = null;
			this.contact = null;
			this.foundation = 0;
			this.slogan = "";	
			this.pictures = null;
			this.industry = null;
			this.subsidiaries = null;
			this.executives = null;
			this.countExecutives = 0;	
			this.parentCompanySlug = "";		

		}

		 // setter
		public void setName(String name) { this.name = name; }
		public void setSlug(String slug) { this.slug = slug; }
		public void setLocation(Location location) { this.location = location; }	
		public void setContact(Contact contactWebsite) { this.contact = contact; }
		public void setfoundation(int foundation) { this.foundation = foundation; }	
		public void setSlogan(String slogan) { this.slogan = slogan; }
		public void setPictures(List<Picture> pictures) { this.pictures = pictures; }
		public void setIndustry(Industry industry) { this.industry = industry; }	
		public void setCountExecutives(int countExecutives) { this.countExecutives = countExecutives; }
		public void setSubsidiaries(List<Company> subsidiaries) { this.subsidiaries = subsidiaries; }
		public void setExecutives(List<Executive> executives) { this.executives = executives; }
		public void setParentCompanySlug(String parentCompanySlug) { this.parentCompanySlug = parentCompanySlug; }
		
		
		// getters
		public String getName() { return name; }
		public String getSlug() { return slug; }
		public Location getLocation() { return location; }
		public Contact getContact() { return contact; }
		public int getfoundation() { return foundation; }
		public String getslogan() { return slogan; }
		public List<Picture> getPictures() { return pictures; }
		public Industry getIndustry() { return industry; }
		public int getCountExecutives() { return countExecutives; }	
		public List<Company> getSubsidiaries() { return subsidiaries; }
		public List<Executive> getExecutives() { return executives; }
		public String getParentCompanySlug() { return parentCompanySlug; }

	      
		  public void writeToParcel(Parcel dest, int flags) {
		    // On ajoute les objets dans l'ordre dans lequel on les a déclarés
		    dest.writeString(name);
		    dest.writeString(slug);
		    dest.writeParcelable(location, flags);
		    dest.writeParcelable(contact, flags);
		    dest.writeInt(foundation);
		    dest.writeString(slogan);
		    dest.writeList(pictures);
		    dest.writeParcelable(industry, flags);
		    dest.writeList(subsidiaries);
		    dest.writeList(executives);
		    dest.writeInt(countExecutives);


		  }
		  
		  public static final Parcelable.Creator<Company> CREATOR = new Parcelable.Creator<Company>() {
			  @Override
			  public Company createFromParcel(Parcel source) {
			    return new Company(source);
			  }

			  @Override
			  public Company[] newArray(int size) {
			    return new Company[size];
			  }
			};

			public Company(Parcel in) {
			  name = in.readString();
			  slug = in.readString();
			  location = in.readParcelable(Location.class.getClassLoader());
			  contact = in.readParcelable(Contact.class.getClassLoader());
			  foundation = in.readInt();
			  slogan = in.readString();
			  in.readList(pictures, Picture.class.getClassLoader()); 
			  industry = in.readParcelable(Industry.class.getClassLoader());
			  in.readList(subsidiaries, Company.class.getClassLoader());
			  in.readList(executives, Executive.class.getClassLoader());
			  countExecutives = in.readInt();

			}

			@Override
			public int describeContents() {
				// TODO Auto-generated method stub
				return 0;
			}
		
		
}
