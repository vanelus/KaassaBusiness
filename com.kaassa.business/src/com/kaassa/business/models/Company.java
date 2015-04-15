package com.kaassa.business.models;

import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Company {
	
		
	  	String name;
	  	String contactEmail;
	  	String contactPhoneone;
	  	String contactWebsite;
	  	String locationAddress;
	  	String locationCityName;
	  	String locationCountryNamefr;
	  	String locationCountryNameen;
	  	int foundation;
	  	String employees;
	  	String slogan;
	  	int picturesId;
	  	String picturesAlt;
	  	String industryNamefr;
	  	String IndustryNameen;
	  	int countryExecutives;
	  	String companySlug;
	  	HashMap<String, Company> subsidiaries = new HashMap<String, Company>();
	  	HashMap<String, Executive> executives = new HashMap<String, Executive>();
	 
	    // constructors
		public Company(String name,String contactEmail,String contactPhoneone,String contactWebsite,String locationAddress,String locationCityName,String locationCountryNamefr,String locationCountryNameen,int foundation,String employees,String slogan,int picturesId,String picturesAlt,String industryNamefr,String IndustryNameen,int countryExecutives, String companySlug, HashMap<String, Company> subsidiaries, HashMap<String, Executive> executives) {
			this.name = name;
			this.contactEmail = contactEmail;
			this.contactPhoneone = contactPhoneone;
			this.contactWebsite = contactWebsite;
			this.locationAddress = locationAddress;
			this.locationCityName = locationCityName;	
			this.locationCountryNamefr = locationCountryNamefr;
			this.locationCountryNameen = locationCountryNameen;
			this.foundation = foundation;
			this.employees = employees;
			this.slogan = slogan;
			this.picturesId = picturesId;		
			this.picturesAlt = picturesAlt;
			this.industryNamefr = industryNamefr;
			this.IndustryNameen = IndustryNameen;
			this.countryExecutives = countryExecutives;
			this.companySlug = companySlug;
			this.subsidiaries = subsidiaries;
			this.executives = executives;
		}
		
		public Company() {
			// TODO Auto-generated constructor stub
			this.name = "";
			this.contactEmail = "";
			this.contactPhoneone = "";
			this.contactWebsite = "";
			this.locationAddress = "";
			this.locationCityName = "";	
			this.locationCountryNamefr = "";
			this.locationCountryNameen = "";
			this.foundation = 0;
			this.employees = "";
			this.slogan = "";
			this.picturesId = 0;		
			this.picturesAlt = "";
			this.industryNamefr = "";
			this.IndustryNameen = "";
			this.countryExecutives = 0;
			this.companySlug = "";
			this.subsidiaries = null;
			this.executives = null;
		}
		 // setter
		public void setname(String name) { this.name = name; }
		public void setcontactEmail(String contactEmail) { this.contactEmail = contactEmail; }
		public void setcontactPhoneone(String contactPhoneone) { this.contactPhoneone = contactPhoneone; }	
		public void setcontactWebsite(String contactWebsite) { this.contactWebsite = contactWebsite; }
		public void setlocationAddress(String locationAddress) { this.locationAddress = locationAddress; }
		public void setlocationCityName(String locationCityName) { this.locationCityName = locationCityName; }
		public void setlocationCountryNamefr(String locationCountryNamefr) { this.locationCountryNamefr = locationCountryNamefr; }
		public void setlocationCountryNameen(String locationCountryNameen) { this.locationCountryNameen = locationCountryNameen; }
		public void setfoundation(int foundation) { this.foundation = foundation; }	
		public void setemployees(String employees) { this.employees = employees; }
		public void setslogan(String slogan) { this.slogan = slogan; }
		public void setpicturesId(int picturesId) { this.picturesId = picturesId; }
		public void setpicturesAlt(String picturesAlt) { this.picturesAlt = picturesAlt; }
		public void setindustryNamefr(String industryNamefr) { this.industryNamefr = industryNamefr; }
		public void setIndustryNameen(String IndustryNameen) { this.IndustryNameen = IndustryNameen; }	
		public void setcompanySlug(String companySlug) { this.companySlug = companySlug; }	
		public void setcountryExecutives(int countryExecutives) { this.countryExecutives = countryExecutives; }
		public void setSubsidiaries(HashMap<String, Company> subsidiaries) { this.subsidiaries = subsidiaries; }
		public void setExecutives(HashMap<String, Executive> executives) { this.executives = executives; }
		
		
		// getters
		public String getname() { return name; }
		public String getcontactEmail() { return contactEmail; }
		public String getcontactPhoneone() { return contactPhoneone; }
		public String getcontactWebsite() { return contactWebsite; }
		public String getlocationAddress() { return locationAddress; }
		public String getlocationCityName() { return locationCityName; }
		public String getlocationCountryNamefr() { return locationCountryNamefr; }
		public String getlocationCountryNameen() { return locationCountryNameen; }
		public int getfoundation() { return foundation; }
		public String getemployees() { return employees; }
		public String getslogan() { return slogan; }
		public int getpicturesId() { return picturesId; }
		public String getpicturesAlt() { return picturesAlt; }
		public String getindustryNamefr() { return industryNamefr; }
		public String getIndustryNameen() { return IndustryNameen; }
		public int getcountryExecutives() { return countryExecutives; }
		public String getcompanySlug() { return companySlug; }		
		public HashMap<String, Company> getSubsidiaries() { return subsidiaries; }
		public HashMap<String, Executive> getExecutives() { return executives; }

		  public int describeContents() {
		    //On renvoie 0, car notre classe ne contient pas de FileDescriptor
		    return 0;
		  }

		  public void writeToParcel(Parcel dest, int flags) {
		    // On ajoute les objets dans l'ordre dans lequel on les a déclarés
		    dest.writeString(name);
		    dest.writeString(contactEmail);
		    dest.writeString(contactPhoneone);
		    dest.writeString(contactWebsite);
		    dest.writeString(locationAddress);
		    dest.writeString(locationCityName);
		    dest.writeString(locationCountryNamefr);
		    dest.writeString(locationCountryNameen);
		    dest.writeInt(foundation);
		    dest.writeString(employees);
		    dest.writeString(slogan);
		    dest.writeInt(picturesId);
		    dest.writeString(picturesAlt);
		    dest.writeString(industryNamefr);
		    dest.writeString(industryNamefr);
		    dest.writeInt(countryExecutives);
		    dest.writeString(companySlug);
		    dest.writeMap(subsidiaries);
		    dest.writeMap(executives);
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
			  Log.i("Read", "ParcelData(Parcel source): time to put back parcel data");
			  name = in.readString();
			  contactEmail = in.readString();
			  contactPhoneone = in.readString();
			  contactWebsite = in.readString();
			  locationAddress = in.readString();
			  locationCityName = in.readString();
			  locationCountryNamefr = in.readString();
			  locationCountryNameen = in.readString();
			  foundation = in.readInt();
			  employees = in.readString();
			  slogan = in.readString();
			  picturesId = in.readInt();
			  picturesAlt = in.readString();
			  industryNamefr = in.readString();
			  IndustryNameen = in.readString();
			  countryExecutives = in.readInt();
			  companySlug = in.readString();  
			  in.readMap(executives, null);
			  in.readMap(executives, null);

			}

	
	      
}
