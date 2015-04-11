/**
 * 
 */
package com.kaassa.business.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author vanel njike
 *
 */
public class CreateDB extends SQLiteOpenHelper {

	//Database version
    private static final int DATABASE_VERSION = 1;
    
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
    
    // Table Create Statements
    // Companies table create statement
    private static final String CREATE_TABLE_COMPANY = "CREATE TABLE "
            + TABLE_COMPANY + "(" 
    		+ KEY_ID + " INTEGER PRIMARY KEY," 
            + KEY_NAME+ " TEXT," 
            + KEY_CONTACT_EMAIL+ " TEXT," 
            + KEY_CONTACT_PHONEONE+ " TEXT," 
            + KEY_CONTACT_WEBSITE+ " TEXT," 
            + KEY_LOCATION_ADDRESS+ " TEXT," 
            + KEY_LOCATION_CITYNAME+ " TEXT," 
            + KEY_LOCATION_COUNTYNAMEFR+ " TEXT," 
            + KEY_LOCATION_COUNTRYNAMEEN+ " TEXT," 
            + KEY_FOUNDATION+ " INTEGER," 
            + KEY_EMPLOYEES+ " INTEGER," 
            + KEY_SLOGAN+ " TEXT," 
            + KEY_PICTUREID+ " INTEGER," 
            + KEY_PICTUREALT+ " TEXT," 
            + KEY_INDUSTRY_NAMEFR+ " TEXT," 
            + KEY_INDUSTRY_NAMEEN+ " TEXT," 
            + KEY_COUNTRY_EXECUTIVES+ " INTEGER," 
            + KEY_PARENT_COMPID+ " INTEGER FOREIGN KEY"  
    		+ ")";
 
    // Executives table create statement
    private static final String CREATE_TABLE_EXECUTIVE = "CREATE TABLE "
            + TABLE_EXECUTIVE + "(" 
    		+ KEY_ID + " INTEGER PRIMARY KEY," 
            + KEY_FIRSTNAME+ " TEXT," 
            + KEY_LASTNAME+ " TEXT," 
            + KEY_GENDER+ " TEXT," 
            + KEY_TITLEEN+ " TEXT," 
            + KEY_ISBOARDMEMBER+ " BOOLEAN," 
            + KEY_COMPID+ " INTEGER FOREIGN KEY"  
    		+ ")";
    
	public CreateDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		//Creating required tables
		db.execSQL(CREATE_TABLE_COMPANY);
		db.execSQL(CREATE_TABLE_EXECUTIVE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		// On Upgradre drop old tables	
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXECUTIVE);
        
        //Create new tables
        onCreate(db);
	}

}
