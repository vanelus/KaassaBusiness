package com.kaassa.business.models;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class HandleDBOperations {

    private SQLiteDatabase db;
    private CreateDB openHelper;
    
    //Database Name
    private static final String DATABASE_NAME = "kaassabusiness.db";
    
    //Tables Name
    private static final String TABLE_COMPANY = "companies";
    private static final String TABLE_EXECUTIVE = "executives";
    
    //Common column names
    private static final String KEY_ID = "Id";
    
    //COMPANY TABLE - column names
    private static final String KEY_NAME = "name";
    private static final String KEY_CONTACT_EMAIL = "contactEmail";
    private static final String KEY_CONTACT_PHONEONE = "contactEmail";
    private static final String KEY_CONTACT_WEBSITE = "contactWebsite";
    private static final String KEY_LOCATION_ADDRESS = "locationAddress";
    private static final String KEY_LOCATION_CITYNAME = "locationCityName";
    private static final String KEY_LOCATION_COUNTYNAMEFR = "locationCountryNamefr";
    private static final String KEY_LOCATION_COUNTRYNAMEEN = "locationCountryNameen";
    private static final String KEY_FOUNDATION = "foundation";
    private static final String KEY_EMPLOYEES = "employees";
    private static final String KEY_SLOGAN = "slogan";
    private static final String KEY_PICTUREID = "industryNamefr";
    private static final String KEY_PICTUREALT = "industryNamefr";
    private static final String KEY_INDUSTRY_NAMEFR = "industryNamefr";
    private static final String KEY_INDUSTRY_NAMEEN = "industryNamefr";
    private static final String KEY_COUNTRY_EXECUTIVES = "countryExecutives";
    private static final String KEY_PARENT_COMPID = "parentCompId";
    
    //EXECUTIVE TABLE - column names
    
    private static final String KEY_FIRSTNAME = "firstname";
    private static final String KEY_LASTNAME = "lastname";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_TITLEEN = "titleEn";
    private static final String KEY_ISBOARDMEMBER = "isBoardMember";
    private static final String KEY_COMPID = "compId";

    public HandleDBOperations(Context context)
    {
        openHelper = new CreateDB(context);
        db = openHelper.getWritableDatabase();
    }
    
    // Creating a Company
    public long createCompany(Company company, List<Company> subsidiaries, List<Executive> executives) {
     
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, company.getname());
        values.put(KEY_CONTACT_EMAIL, company.getcontactEmail());
        values.put(KEY_CONTACT_PHONEONE, company.getcontactPhoneone());
        values.put(KEY_CONTACT_WEBSITE, company.getcontactWebsite());
        values.put(KEY_LOCATION_ADDRESS, company.getlocationAddress());
        values.put(KEY_LOCATION_CITYNAME, company.getlocationCityName());
        values.put(KEY_LOCATION_COUNTYNAMEFR, company.getlocationCountryNameen());
        values.put(KEY_LOCATION_COUNTRYNAMEEN, company.getlocationCountryNamefr());
        values.put(KEY_FOUNDATION, company.getfoundation());
        values.put(KEY_EMPLOYEES, company.getemployees());
        values.put(KEY_SLOGAN, company.getslogan());
        values.put(KEY_PICTUREID, company.getpicturesId());
        values.put(KEY_PICTUREALT, company.getpicturesAlt());
        values.put(KEY_INDUSTRY_NAMEFR, company.getindustryNamefr());
        values.put(KEY_INDUSTRY_NAMEEN, company.getIndustryNameen());
        values.put(KEY_COUNTRY_EXECUTIVES, company.getcountryExecutives());
        
     
        // insert row
        long company_id = db.insert(TABLE_COMPANY, null, values);
     
        // assigning subsidiaries to Company
        if (subsidiaries.size() > 0)
        {
            for (Company subsidiary : subsidiaries) {
                createSubsidiary(company_id, subsidiary, executives);
            }
        	
        }
        
        
        // assigning executives to Company
        if (executives.size() > 0)
        {
            for (Executive executive : executives) {
                createExecutive(company_id, executive);
            }
        	
        }

     
        return company_id;
    }
    
    // Creating a Subsidiary
    public long createSubsidiary(long company_id, Company subsidiary, List<Executive> executives) {
		// TODO Auto-generated method stub
		
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, subsidiary.getname());
        values.put(KEY_CONTACT_EMAIL, subsidiary.getcontactEmail());
        values.put(KEY_CONTACT_PHONEONE, subsidiary.getcontactPhoneone());
        values.put(KEY_CONTACT_WEBSITE, subsidiary.getcontactWebsite());
        values.put(KEY_LOCATION_ADDRESS, subsidiary.getlocationAddress());
        values.put(KEY_LOCATION_CITYNAME, subsidiary.getlocationCityName());
        values.put(KEY_LOCATION_COUNTYNAMEFR, subsidiary.getlocationCountryNameen());
        values.put(KEY_LOCATION_COUNTRYNAMEEN, subsidiary.getlocationCountryNamefr());
        values.put(KEY_FOUNDATION, subsidiary.getfoundation());
        values.put(KEY_EMPLOYEES, subsidiary.getemployees());
        values.put(KEY_SLOGAN, subsidiary.getslogan());
        values.put(KEY_PICTUREID, subsidiary.getpicturesId());
        values.put(KEY_PICTUREALT, subsidiary.getpicturesAlt());
        values.put(KEY_INDUSTRY_NAMEFR, subsidiary.getindustryNamefr());
        values.put(KEY_INDUSTRY_NAMEEN, subsidiary.getIndustryNameen());
        values.put(KEY_COUNTRY_EXECUTIVES, subsidiary.getcountryExecutives());
        values.put(KEY_PARENT_COMPID, company_id);
        
             
        // insert row
        long subsidiary_id = db.insert(TABLE_COMPANY, null, values);
        
        // assigning executives to Subsidiary
        if (executives.size() > 0)
        {
            for (Executive executive : executives) {
                createExecutive(company_id, executive);
            }
        	
        }
        
        return subsidiary_id;
	}
    
    // Creating an Executive
	public long createExecutive(long company_id, Executive executive) {
		// TODO Auto-generated method stub
		
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, executive.getFirstname());
        values.put(KEY_LASTNAME, executive.getLastname());
        values.put(KEY_GENDER, executive.getGender());
        values.put(KEY_TITLEEN, executive.getTitleEn());
        values.put(KEY_ISBOARDMEMBER, executive.getIsBoardMember());
        values.put(KEY_COMPID, company_id);
        
        // insert row
        long executive_id = db.insert(TABLE_EXECUTIVE, null, values);
        
        return executive_id;
	}

	// Get a single Company
	// Example: SELECT * FROM companies WHERE id = 1;
	public Company getCompany(long company_id) {
	 
	    String selectQuery = "SELECT  * FROM " + TABLE_COMPANY + " WHERE "
	            + KEY_ID + " = " + company_id;
	 
	    Log.e("getCompany", selectQuery);
	 
	    Cursor c = db.rawQuery(selectQuery, null);
	 
	    if (c != null)
	        c.moveToFirst();
	 
	    Company comp = new Company();
	    comp.setname((c.getString(c.getColumnIndex(KEY_NAME))));
	    comp.setcontactEmail(c.getString(c.getColumnIndex(KEY_CONTACT_EMAIL)));
	    comp.setcontactPhoneone(c.getString(c.getColumnIndex(KEY_CONTACT_PHONEONE)));
	    comp.setcontactWebsite((c.getString(c.getColumnIndex(KEY_CONTACT_WEBSITE))));
	    comp.setlocationAddress(c.getString(c.getColumnIndex(KEY_LOCATION_ADDRESS)));
	    comp.setlocationCityName(c.getString(c.getColumnIndex(KEY_LOCATION_CITYNAME)));
	    comp.setlocationCountryNameen((c.getString(c.getColumnIndex(KEY_LOCATION_COUNTYNAMEFR))));
	    comp.setlocationCountryNamefr(c.getString(c.getColumnIndex(KEY_LOCATION_COUNTRYNAMEEN)));
	    comp.setfoundation(c.getInt(c.getColumnIndex(KEY_FOUNDATION)));
	    comp.setemployees((c.getInt(c.getColumnIndex(KEY_EMPLOYEES))));
	    comp.setslogan(c.getString(c.getColumnIndex(KEY_SLOGAN)));
	    comp.setpicturesId(c.getInt(c.getColumnIndex(KEY_PICTUREID)));
	    comp.setpicturesAlt(c.getString(c.getColumnIndex(KEY_PICTUREALT)));
	    comp.setindustryNamefr(c.getString(c.getColumnIndex(KEY_INDUSTRY_NAMEFR)));
	    comp.setIndustryNameen(c.getString(c.getColumnIndex(KEY_INDUSTRY_NAMEEN)));
	    comp.setcountryExecutives(c.getInt(c.getColumnIndex(KEY_COUNTRY_EXECUTIVES)));
	    comp.setparentCompId(c.getInt(c.getColumnIndex(KEY_PARENT_COMPID)));
	    
	 
	    return comp;
	}
	
	// Getting all Companies
	// Example : SELECT * FROM companies;
	public List<Company> getAllCompanies() {
	    List<Company> companies = new ArrayList<Company>();
	    String selectQuery = "SELECT  * FROM " + TABLE_COMPANY;
	 
	    Log.e("getAllCompanies", selectQuery);
	 
	    Cursor c = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (c.moveToFirst()) {
	        do {
	            Company comp = new Company();
	    	    comp.setname((c.getString(c.getColumnIndex(KEY_NAME))));
	    	    comp.setcontactEmail(c.getString(c.getColumnIndex(KEY_CONTACT_EMAIL)));
	    	    comp.setcontactPhoneone(c.getString(c.getColumnIndex(KEY_CONTACT_PHONEONE)));
	    	    comp.setcontactWebsite((c.getString(c.getColumnIndex(KEY_CONTACT_WEBSITE))));
	    	    comp.setlocationAddress(c.getString(c.getColumnIndex(KEY_LOCATION_ADDRESS)));
	    	    comp.setlocationCityName(c.getString(c.getColumnIndex(KEY_LOCATION_CITYNAME)));
	    	    comp.setlocationCountryNameen((c.getString(c.getColumnIndex(KEY_LOCATION_COUNTYNAMEFR))));
	    	    comp.setlocationCountryNamefr(c.getString(c.getColumnIndex(KEY_LOCATION_COUNTRYNAMEEN)));
	    	    comp.setfoundation(c.getInt(c.getColumnIndex(KEY_FOUNDATION)));
	    	    comp.setemployees((c.getInt(c.getColumnIndex(KEY_EMPLOYEES))));
	    	    comp.setslogan(c.getString(c.getColumnIndex(KEY_SLOGAN)));
	    	    comp.setpicturesId(c.getInt(c.getColumnIndex(KEY_PICTUREID)));
	    	    comp.setpicturesAlt(c.getString(c.getColumnIndex(KEY_PICTUREALT)));
	    	    comp.setindustryNamefr(c.getString(c.getColumnIndex(KEY_INDUSTRY_NAMEFR)));
	    	    comp.setIndustryNameen(c.getString(c.getColumnIndex(KEY_INDUSTRY_NAMEEN)));
	    	    comp.setcountryExecutives(c.getInt(c.getColumnIndex(KEY_COUNTRY_EXECUTIVES)));
	    	    comp.setparentCompId(c.getInt(c.getColumnIndex(KEY_PARENT_COMPID)));
	 
	            // adding to company list
	            companies.add(comp);
	        } while (c.moveToNext());
	    }
	 
	    return companies;
	}
	
	// Get a single Executive
	public Executive getExecutive(long company_id) {
		 
	    String selectQuery = "SELECT  * FROM " + TABLE_COMPANY + " WHERE "
	            + KEY_ID + " = " + company_id;
	 
	    Log.e("getExecutive", selectQuery);
	 
	    Cursor c = db.rawQuery(selectQuery, null);
	 
	    if (c != null)
	        c.moveToFirst();
	 
	    Executive ex = new Executive();
	    ex.setFirstname(c.getString(c.getColumnIndex(KEY_FIRSTNAME)));
	    ex.setLastname(c.getString(c.getColumnIndex(KEY_LASTNAME)));
	    ex.setGender((c.getString(c.getColumnIndex(KEY_GENDER))));
	    ex.setTitleEn(c.getString(c.getColumnIndex(KEY_TITLEEN)));
	    ex.setIsBoardMember((Boolean)c.getInt((c.getColumnIndex(KEY_ISBOARDMEMBER)));
	    ex.setCompId((c.getInt(c.getColumnIndex(KEY_COMPID))));
	 
	    return ex;
	}

	// Getting all Executives
	public List<Executive> getAllExecutives() {
	    List<Executive> executives = new ArrayList<Executive>();
	    String selectQuery = "SELECT  * FROM " + TABLE_COMPANY;
	 
	    Log.e("getAllExecutives", selectQuery);
	 
	    Cursor c = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (c.moveToFirst()) {
	        do {
	            Executive ex = new Executive();
	    	    ex.setFirstname(c.getString(c.getColumnIndex(KEY_FIRSTNAME)));
	    	    ex.setLastname(c.getString(c.getColumnIndex(KEY_LASTNAME)));
	    	    ex.setGender((c.getString(c.getColumnIndex(KEY_GENDER))));
	    	    ex.setTitleEn(c.getString(c.getColumnIndex(KEY_TITLEEN)));
	    	    ex.setIsBoardMember((Boolean)c.getInt((c.getColumnIndex(KEY_ISBOARDMEMBER)));
	    	    ex.setCompId((c.getInt(c.getColumnIndex(KEY_COMPID))));
	 
	            // adding to executive list
	            executives.add(ex);
	        } while (c.moveToNext());
	    }
	 
	    return executives;
	}
	
	// deleting a Company
	public void deleteCompany(long tado_id) {
	    db.delete(TABLE_COMPANY, KEY_ID + " = ?",
	            new String[] { String.valueOf(tado_id) });
	}
	
	// deleting all Companies
	public void deleteAllCompanies(long tado_id) {

	    db.execSQL("delete from " + TABLE_COMPANY);
        db.execSQL("vacuum");
	}
	
	// deleting a Executive
	public void deleteExecutive(long tado_id) {
	    db.delete(TABLE_EXECUTIVE, KEY_ID + " = ?",
	            new String[] { String.valueOf(tado_id) });
	}
	
	// deleting all Executives
	public void deleteAllExecutives(long tado_id) {
	    db.execSQL("delete from " + TABLE_EXECUTIVE);
        db.execSQL("vacuum");
	}
   
}
