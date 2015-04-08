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

    private static final String DATABASE_NAME = "kaassa.db";
    private static final int DATABASE_VERSION = 1;
    public static final String KAASSAHOTEL_COLUMN_HOTECONTACTWEBSITE = "HotelContactWeb_site";
    public static final String KAASSAHOTEL_COLUMN_HOTELBILLINGPRICEMIN = "HotelBillingPrice_min";
    public static final String KAASSAHOTEL_COLUMN_HOTELCONTACTEMAIL = "HotelContactEmail";
    public static final String KAASSAHOTEL_COLUMN_HOTELCONTACTPHONEONE = "HotelContactPhone_one";
    public static final String KAASSAHOTEL_COLUMN_HOTELCONTACTPHONETWO = "HotelContactPhone_two";
    public static final String KAASSAHOTEL_COLUMN_HOTELLOCATIONADDRESS = "HotelLocationAddress";
    public static final String KAASSAHOTEL_COLUMN_HOTELLOCATIONCITYNAME = "HotelLocationCityName";
    public static final String KAASSAHOTEL_COLUMN_HOTELLOCATIONCOUNTNAMEFR = "HotelLocationCountryName_fr";
    public static final String KAASSAHOTEL_COLUMN_HOTELNAME = "HotelName";
    public static final String KAASSAHOTEL_COLUMN_HOTELSERVICESNAMEEN = "HotelServicesName_en";
    public static final String KAASSAHOTEL_COLUMN_HOTELSTARS = "HotelStars";
    public static final String KAASSAHOTEL_COLUMN_ID = "id";
    private static final String TABLE_NAME = "hotelrecords";
    
	public CreateDB(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
