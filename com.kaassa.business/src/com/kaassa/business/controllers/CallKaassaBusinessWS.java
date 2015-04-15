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
import com.kaassa.business.models.Executive;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Toast;

public class CallKaassaBusinessWS 
{
	
	//Instantiate Companies collection
	HashMap<String, Company> companies = new HashMap<String, Company>();
	
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
	public List<Company> getJsonData(String searchedCompany, Context myContext)
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
	        //Creating list object for storing the parsed companies
            List<Company> companiesList = new ArrayList<Company>();
	        
            //Creating JSON object from string
            JSONObject json = new JSONObject(jsonString);
 
            //Making sure that companies list array exists
            if (!json.isNull("companies"))
            {
                //Getting companies array
                JSONArray array = json.getJSONArray("companies");
                 
                //Creating empty json object for companies loop
                JSONObject currentCompany;
                 
                //looping all the companies and adding them parsed one by one to the list
                for (int i = 0 ; i < array.length() ; i ++)
                {
                	currentCompany = array.getJSONObject(i);
                    
                	//Method to parse companies and add them to the list
                	addCurrentCompanyToCompaniesList(currentCompany, companiesList);
                }
                //Returning parsed companies list
                return companiesList;
            }
            else
            {
                return null;
            }
	        
        } catch (Exception e) {
            Log.e("EXC", "Error", e);
            return null;
        }
	}


	private void addCurrentCompanyToCompaniesList(JSONObject currentCompany,List<Company> companiesList) 
	{

	     //Initializing Company Object
        Company company = new Company();
         

        //Creating empty list for subsidiaries
	  	HashMap<String, Company> subsidiaries = new HashMap<String, Company>();
	  	//Creating empty list for executives
	  	HashMap<String, Executive> executives = new HashMap<String, Executive>();
	  	
        try {
            //Parsing company's details.
        	company.setname(currentCompany.optString("name"));
        	company.setcontactEmail(currentCompany.getJSONObject("contact").optString("email"));
        	company.setcontactPhoneone(currentCompany.getJSONObject("contact").optString("phone_one"));
        	company.setcontactWebsite(currentCompany.getJSONObject("contact").optString("phone_two"));
        	company.setlocationAddress(currentCompany.getJSONObject("location").optString("address"));
        	company.setlocationCityName(currentCompany.getJSONObject("location").getJSONObject("city").optString("phone_two"));
        	company.setlocationCountryNamefr(currentCompany.getJSONObject("location").getJSONObject("country").optString("name_f_r"));
        	company.setlocationCountryNameen(currentCompany.getJSONObject("location").getJSONObject("country").optString("name_e_n"));
        	company.setfoundation(currentCompany.optInt("foundation"));
        	company.setemployees(currentCompany.optString("employees"));
//        	company.setpicturesId(currentCompany.getJSONArray("pictures").get(0)optInt(0,"id"));
//        	company.setpicturesAlt(currentCompany.getJSONArray("pictures").optString(0, "alt"));
        	company.setindustryNamefr(currentCompany.getJSONObject("industry").optString("name_f_r"));
        	company.setIndustryNameen(currentCompany.getJSONObject("industry").optString("name_e_n"));
        	company.setcompanySlug(currentCompany.optString("slug"));

 
            
        	/*
//Making sure that company's subsidiaries list array exists
            if (!currentCompany.isNull("children"))
            {
                //Getting subsidiaries array
                JSONArray array = currentCompany.getJSONArray("children");
                 
                //Creating empty json object for subsidiaries loop
                JSONObject currentSubsidiary;
                 
                //looping all the company's subsidiaries and adding them parsed one by one to the list
                for (int i = 0 ; i < array.length() ; i ++){
                    currentSubsidiary = array.getJSONObject(i);
                     
                    //Method to parse subsidiaries and add them to the list
                    addCurrentSubsidiaryToSubsidiariesList(company, currentSubsidiary, subsidiaries);
                }
            }
			//Setting company's executives
            company.setSubsidiaries(subsidiaries);
*/
			//Making sure that company's executives list array exists
            if (!currentCompany.isNull("executives"))
            {
                //Getting executives array
                JSONArray array = currentCompany.getJSONArray("executives");
                 
                //Creating empty json object for executives loop
                JSONObject currentExecutive;
                 
                //looping all the company's executives and adding them parsed one by one to the list
                for (int i = 0 ; i < array.length() ; i ++){
                    currentExecutive = array.getJSONObject(i);
                     
                    //Method to parse executives and add them to the list
                    addCurrentExecutiveToExecutivesList(company, currentExecutive, executives);
                }
            }
			//Setting company's executives
            company.setExecutives(executives);
            
            
			//Adding company to the list
            companiesList.add(company);
            Log.d("Added company", "Added company: "+ company.toString()); 
        } catch (JSONException e) {
            Log.e("Exception", "Exception thrown on adding company to companies list: "+ e.toString());
            e.printStackTrace();
        }  
	}


	private void addCurrentExecutiveToExecutivesList(Company parentCompany, JSONObject currentExecutive, HashMap<String, Executive> executives) 
	{
	     //Initializing Executive Object
		  Executive executive = new Executive();
		  //Parsing company's details.
		  executive.setFirstname(currentExecutive.optString("firstname"));
		  executive.setLastname(currentExecutive.optString("lastname"));
		  executive.setGender(currentExecutive.optString("gender"));
		  executive.setTitleEn(currentExecutive.optString("title_e_n"));
		  executive.setIsBoardMember(currentExecutive.optBoolean("is_board_member"));
		  executive.setCompany(parentCompany);
  
			//Adding executive to the list
		 	executives.put(currentExecutive.optString("firstname"), executive); 
		
	}


	private void addCurrentSubsidiaryToSubsidiariesList(Company parentCompany, JSONObject currentSubsidiary, HashMap<String, Company> subsidiaries) 
	{
		
	}

}
