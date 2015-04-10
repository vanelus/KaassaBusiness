package com.kaassa.business.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Executive 
{
	  	String firstname;
	  	String lastname;
	  	String gender;
	  	String titleEn;
	  	Boolean isBoardMember;
	    int compId;
	 
	    // constructors
		public Executive(String firstname,String lastname,String gender,String titleEn,Boolean isBoardMember,int compId) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.gender = gender;
			this.titleEn = titleEn;
			this.isBoardMember = isBoardMember;
			this.compId = compId;			
		}
		
		 // setter
		public void setFirstname(String firstname) { this.firstname = firstname; }
		public void setLastname(String lastname) { this.lastname = lastname; }
		public void setGender(String gender) { this.gender = gender; }	
		public void setTitleEn(String titleEn) { this.titleEn = titleEn; }
		public void setIsBoardMember(Boolean HotelStars) { this.isBoardMember = isBoardMember; }
		public void setCompId(int compId) { this.compId = compId; }
		
		
		// getters
		public String getFirstname() { return firstname; }
		public String getLastname() { return lastname; }
		public String getGender() { return gender; }
		public String getTitleEn() { return titleEn; }
		public Boolean getIsBoardMember() { return isBoardMember; }
		public int getcompId() { return compId; }

		
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
		    dest.writeInt((Boolean) isBoardMember ? 1 : 0);
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
			  isBoardMember = (Boolean) in.readValue( null );
			  compId = in.readInt();


			}
	      
	
}
