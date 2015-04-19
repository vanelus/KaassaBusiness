package com.kaassa.business.views;

import com.kaassa.business.R;
import com.kaassa.business.controllers.CompanyAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CompanyList extends Activity {

	 CompanyAdapter companyAdapter;
	
	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.companypage);
	        
	        ListView listView = (ListView)findViewById(R.id.companies_list);
	        companyAdapter = new CompanyAdapter();
	    	listView.setAdapter(companyAdapter);
	    	
	    }
	
}
