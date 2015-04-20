package com.kaassa.business.views;

import java.util.Locale;

import com.kaassa.business.R;
import com.kaassa.business.controllers.CompanyAdapter;
import com.kaassa.business.controllers.ManageViewTransitions;
import com.kaassa.business.models.Company;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

public class CompanyList extends Activity {

	 CompanyAdapter companyAdapter;
	 //search filter on company page. based on company name
	 EditText editsearch;
	 ManageViewTransitions manageView = new ManageViewTransitions();
	
	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.companypage);
	        
	        ListView companies_list = (ListView)findViewById(R.id.companies_list);
	        companyAdapter = new CompanyAdapter();
	        companies_list.setAdapter(companyAdapter);
	    	
	    	//Handle click on company from "Companies List"
	        companies_list.setOnItemClickListener(new AdapterView.OnItemClickListener() 
    		{
    			@Override
    			public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {


    	    	    
    	    	    // Get Hotel "behind" the clicked item
    				Company company =  (Company) arg0.getAdapter().getItem(position);
    				
    				// Call the Transition method From the current view to "Companies List View"
    				manageView.CompanylistToCompanydetail(v.getContext(), company);
    	    	    
      

    	    	}
    		});

			// Locate the EditText in listview_main.xml
			editsearch = (EditText) findViewById(R.id.search);
	 
			// Capture Text in EditText
			editsearch.addTextChangedListener(new TextWatcher() {
	 
				@Override
				public void afterTextChanged(Editable arg0) {
					// TODO Auto-generated method stub
					String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
					companyAdapter.filterCompanyByName(text,getBaseContext());
									
				}

				@Override
				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onTextChanged(CharSequence s, int start,
						int before, int count) {
					// TODO Auto-generated method stub
					
				}
	
	 
			});
	    	
	    }
	
}
