package com.kaassa.business.views;

import com.kaassa.business.R;
import com.kaassa.business.models.Company;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;


public class CompanyDetail extends FragmentActivity{
	
	 
	 @Override
	 protected void onCreate(Bundle savedInstanceState) 
	 {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.companydetail);
		 
		 //Get the selected company from "CompanyList View"
		 Company selectedCompany = getIntent().getParcelableExtra("com.kaassa.business.controllers.company");
		 
		 ExecutiveFragment executivefragment = (ExecutiveFragment)getSupportFragmentManager().findFragmentById(R.id.executivefragment);
		 SubsidiaryFragment subsidiaryfragment = (SubsidiaryFragment)getSupportFragmentManager().findFragmentById(R.id.subsidiaryfragment);

		 
        if (executivefragment != null) {
            // If executivefragment exist

            // Call a method in the executivefragment to update its list
        	//executivefragment.setListExecutive(selectedCompany.getExecutives());
        }
        
        if (subsidiaryfragment != null) {
            // If subsidiaryfragment exist

            // Call a method in the executivefragment to update its list
        	subsidiaryfragment.setListSubsidiary(selectedCompany.getSubsidiaries());
        }
        
        //Set Company details fields
		TextView company_name = (TextView)findViewById(R.id.company_name);
		TextView industry_name_en = (TextView)findViewById(R.id.industry_name_en);
		TextView location_city_and_country_name = (TextView)findViewById(R.id.location_city_and_country_name);
		TextView count_executives = (TextView)findViewById(R.id.count_executives);
		
		company_name.setText(selectedCompany.getName());
		location_city_and_country_name.setText(selectedCompany.getLocation().getCity().getName() + " - " + selectedCompany.getLocation().getAddress() + "(" + selectedCompany.getLocation().getCountry().getNameEn() + ")");		
		industry_name_en.setText(selectedCompany.getIndustry().getNameEn());
		count_executives.setText(String.valueOf(selectedCompany.getCountExecutives()) + " executives");
	 }
	 

	 
		
	}
