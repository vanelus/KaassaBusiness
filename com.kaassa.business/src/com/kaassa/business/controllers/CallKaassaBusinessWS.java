package com.kaassa.business.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kaassa.business.models.Company;
import com.kaassa.business.models.Contact;
import com.kaassa.business.models.Executive;
import com.kaassa.business.models.Industry;
import com.kaassa.business.models.Location;
import com.kaassa.business.models.Picture;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Toast;

public class CallKaassaBusinessWS 
{
	
	//Instantiate Companies collection
	//Creating list object for storing the parsed companie
	public static List<Company> companiesList = new ArrayList<Company>();
	
	
	// getters
	public List<Company> getCompaniesList() { return companiesList; }
		
	
	/**
	  * @desc Save datas in "in-memory" object collections from jsondata.
	  * @param Context myContext
	  * @param String jsonDataResult
	  * @return void
	*/
	public void saveCompaniesFromJson(Context myContext, List<Company> companiesList)
	{

    	

		
    	Gson gson = new Gson();
    	Company response = gson.fromJson(companiesList.toString(), Company.class);

    	
    	
 
		
	}
	
	
	/**
	  * @desc Call a Web service From the search button (homepage view) to get companies and executives and return related json data
	  * @param String searchedCompany
	  * @param Context myContext
	  * @return String - jsonDataResult 
	*/
	public void getJsonData(String searchedCompany, Context myContext)
	{
		
			AssetManager mngr = myContext.getAssets();
			
		    //get the json text -in asset rep
			InputStream is = null;
		    try 
		    {
		    	is = mngr.open("kaassa-conglomerates.json");
			} 
		    catch (IOException e) {
				e.printStackTrace();
			}
		         
	        // check the value
	        int ch;  
	        StringBuffer str = new StringBuffer();  
	          
			try 
			{
				while ((ch = is.read()) != -1)  
					str.append((char) ch);
			} 
			catch (IOException e2) {
				e2.printStackTrace();
			}

	        String jsonString = str.toString();
	        
	        Log.i("JsonData: ",jsonString);
	        
	        try
	        {	        
            //Creating JSON object from string
            JSONObject json = new JSONObject(jsonString);
 
            //Making sure that companies list array exists
            if (!json.isNull("companies"))
            {
                //Getting companies array
                JSONArray array = json.getJSONArray("companies");
                 
                //Creating empty json object for companies loop
                JSONObject currentCompany;
                 
                Gson gson = new Gson();
                
                //looping all the companies and adding them parsed one by one to the list
                for (int i = 0 ; i < array.length() ; i ++)
                {
                	currentCompany = array.getJSONObject(i);
                	Company company = gson.fromJson(currentCompany.toString(), Company.class);
                	companiesList.add(company);

                }
            }
	        
        } catch (Exception e) {
            Log.e("EXC", "Error", e);
        }
	}




}
