package com.kaassa.business.models;

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
	  	int employees;
	  	String slogan;
	  	int picturesId;
	  	String picturesAlt;
	  	String industryNamefr;
	  	String IndustryNameen;
	  	int countryExecutives;
	  	int parentCompId;

	 
	    // constructors
		public Company(String name,String contactEmail,String contactPhoneone,String contactWebsite,String locationAddress,String locationCityName,String locationCountryNamefr,String locationCountryNameen,int foundation,int employees,String slogan,int picturesId,String picturesAlt,String industryNamefr,String IndustryNameen,int countryExecutives,int parentCompId) {
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
			this.parentCompId = parentCompId;
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
		public void setfoundation(String foundation) { this.foundation = foundation; }	
		public void setemployees(String employees) { this.employees = employees; }
		public void setslogan(Boolean slogan) { this.slogan = slogan; }
		public void setpicturesId(int picturesId) { this.picturesId = picturesId; }
		public void setpicturesAlt(String picturesAlt) { this.picturesAlt = picturesAlt; }
		public void setindustryNamefr(String industryNamefr) { this.industryNamefr = industryNamefr; }
		public void seIndustryNameen(String IndustryNameen) { this.IndustryNameen = IndustryNameen; }	
		public void countryExecutives(String countryExecutives) { this.countryExecutives = countryExecutives; }
		public void setIsBoardMember(Boolean parentCompId) { this.parentCompId = parentCompId; }
		public void setparentCompId(int compId) { this.compId = compId; }
		
		
		// getters
		public String getname() { return name; }
		public String getcontactEmail() { return contactEmail; }
		public String getcontactPhoneone() { return contactPhoneone; }
		public String getcontactWebsite() { return contactWebsite; }
		public Boolean getlocationAddress() { return locationAddress; }
		public int getlocationCityName() { return locationCityName; }
		public String getlocationCountryNamefr() { return locationCountryNamefr; }
		public String getlocationCountryNameen() { return locationCountryNameen; }
		public String getfoundation() { return foundation; }
		public String getemployees() { return titleEn; }
		public Boolean getIsBoardMember() { return employees; }
		public int getcompId() { return compId; }
		public String getFirstname() { return firstname; }
		public String getLastname() { return lastname; }
		public String getGender() { return gender; }
		public String getTitleEn() { return titleEn; }
		public Boolean getIsBoardMember() { return isBoardMember; }
		public int getcompId() { return compId; }

		
		public void getname(String name) { this.name = name; }
		public void getcontactEmail(String contactEmail) { this.contactEmail = contactEmail; }
		public void getcontactPhoneone(String contactPhoneone) { this.contactPhoneone = contactPhoneone; }	
		public void getcontactWebsite(String contactWebsite) { this.contactWebsite = contactWebsite; }
		public void getlocationAddress(String locationAddress) { this.locationAddress = locationAddress; }
		public void getlocationCityName(String locationCityName) { this.locationCityName = locationCityName; }
		public void getlocationCountryNamefr(String locationCountryNamefr) { this.locationCountryNamefr = locationCountryNamefr; }
		public void getlocationCountryNameen(String locationCountryNameen) { this.locationCountryNameen = locationCountryNameen; }
		public void getfoundation(String foundation) { this.foundation = foundation; }	
		public void getemployees(String employees) { this.employees = employees; }
		public void slogan(Boolean slogan) { this.slogan = slogan; }
		public void getpicturesId(int picturesId) { this.picturesId = picturesId; }
		public void getpicturesAlt(String picturesAlt) { this.picturesAlt = picturesAlt; }
		public void getindustryNamefr(String industryNamefr) { this.industryNamefr = industryNamefr; }
		public void seIndustryNameen(String IndustryNameen) { this.IndustryNameen = IndustryNameen; }	
		public void countryExecutives(String countryExecutives) { this.countryExecutives = countryExecutives; }
		public void getIsBoardMember(Boolean parentCompId) { this.parentCompId = parentCompId; }
		public void getparentCompId(int compId) { this.compId = compId; }
		
		  public int describeContents() {
		    //On renvoie 0, car notre classe ne contient pas de FileDescriptor
		    return 0;
		  }

		  public void writeToParcel(Parcel dest, int flags) {
		    // On ajoute les objets dans l'ordre dans lequel on les a déclarés
		    dest.writeString(firstname);
		    dest.writeString(lastname);
		    dest.writeString(gender);
		    dest.writeString(titleEn);
		    dest.writeByte(isBoardMember);
		    dest.writeInt(compId);
		  }
		  
		  public static final Parcelable.Creator<Executive> CREATOR = new Parcelable.Creator<Executive>() {
			  @Override
			  public Executive createFromParcel(Parcel source) {
			    return new Executive(source);
			  }

			  @Override
			  public Executive[] newArray(int size) {
			    return new Executive[size];
			  }
			};

			public Executive(Parcel in) {
			  Log.i("Read", "ParcelData(Parcel source): time to put back parcel data");
			  firstname = in.readString();
			  lastname = in.readString();
			  gender = in.readString();
			  gender = in.readString();
			  isBoardMember = in.readString();
			  compId = in.readInt();


			}
	      
}
