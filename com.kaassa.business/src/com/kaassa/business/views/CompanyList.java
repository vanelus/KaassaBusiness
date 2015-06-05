package com.kaassa.business.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.kaassa.business.R;
import com.kaassa.business.controllers.CallKaassaBusinessWS;
import com.kaassa.business.controllers.CompanyAdapter;
import com.kaassa.business.controllers.ManageViewTransitions;
import com.kaassa.business.models.Company;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class CompanyList extends Activity implements OnClickListener {

	private int LAYOUT_TYPE = 1;
	 private List<Company> companiesList = new ArrayList<Company>();
	 CompanyAdapter companyAdapter;
	 //search filter on company page. based on company name
	 EditText editsearch;
	 
	//Indicator: Display the current companies number
	 TextView companies_list_results_count;
	 ManageViewTransitions manageView = new ManageViewTransitions();
	
	 Dialog dialog;
     Spinner industry_spinner ;
     Spinner country_spinner;
     String searchedCountry = "";
     String searchedIndustry = "";
 
 
	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.companypage);
	        
			CallKaassaBusinessWS callKaassaWS = new CallKaassaBusinessWS();
			companiesList = callKaassaWS.getCompaniesList();
	        
	        ListView companies_list = (ListView)findViewById(R.id.companies_list);
	        companyAdapter = new CompanyAdapter((ArrayList<Company>) companiesList, LAYOUT_TYPE);
	        companies_list.setAdapter(companyAdapter);
	        
	        //Set company list results count
	        companies_list_results_count = (TextView)findViewById(R.id.companies_list_results_count);
	        companies_list_results_count.setText("Results : " + companies_list.getCount() + " companies...");
	        
	        
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
			
			// Locate the ResultSet Textview in listview_main.xml
			companies_list_results_count = (TextView) findViewById(R.id.companies_list_results_count);
	 
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
	 
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.companylistmenu, menu);	 
			 
			return true;
		} 
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar item clicks here. The action bar will
			// automatically handle clicks on the Home/Up button, so long
			// as you specify a parent activity in AndroidManifest.xml.
			int id = item.getItemId();
			
			
			switch(id) 
			{
				case R.id.menu_company_filter:
					
					//show filter dialog on companies listview
					displayFilterDialog(companyAdapter.industriesList, companyAdapter.countriesList);
	                
	                break;
	                
			    default:
			        return super.onOptionsItemSelected(item);
			}
			return false;
		}

		private void displayFilterDialog(List<String> industriesList, List<String> countriesList) 
		{
			// TODO Auto-generated method stub
			//Display a dialog to filter the hotellist	
			dialog = new Dialog(this);
			
            // Include dialog.xml file
            dialog.setContentView(R.layout.dialog_companylist_filter);
            
            // Set dialog title
            dialog.setTitle(R.string.menu_company_filter_text);
            
            //Get Dialog Item views
            industry_spinner = (Spinner)dialog.findViewById(R.id.companylist_filter_industry_spinner); 
            country_spinner = (Spinner)dialog.findViewById(R.id.companylist_filter_country_spinner);
            Button cancel_button = (Button)dialog.findViewById(R.id.companylist_filter_cancel_button);
            Button submit_button = (Button)dialog.findViewById(R.id.companylist_filter_submit_button);
            
            // Set Countries Spinner Values
            ArrayAdapter<String> adapter_country_spinner = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,countriesList);
            country_spinner.setAdapter(adapter_country_spinner);
            adapter_country_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            
            // Set Industries Spinner Values
            ArrayAdapter<String> adapter_industry_spinner = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,industriesList);
            industry_spinner.setAdapter(adapter_industry_spinner);
            adapter_industry_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            
            
            // Display the dialog filter
            dialog.show();
            cancel_button.getId();
            
            
            // if decline button is clicked, close the custom dialog
            cancel_button.setOnClickListener(this);
            submit_button.setOnClickListener(this);
		}

		public void onClick(View v) 
		{
		    //Handle based on which view was clicked.
			int viewid = v.getId();
			
			switch(viewid) {
				case R.id.companylist_filter_cancel_button:
					closeDialog();
					
					break;
				
				case R.id.companylist_filter_submit_button:
					callCompaniesFilter();
					setCompResultNumber();
					break;
			}
							
		}
	      
		private OnClickListener callCompaniesFilter() {
			// TODO Auto-generated method stub
			
	        // Close dialog
			dialog.dismiss();
			
        	// Get selected filter values
            if (country_spinner.getSelectedItem() != null)
            	searchedCountry = country_spinner.getSelectedItem().toString();
            
            if (industry_spinner.getSelectedItem() != null)
            	searchedIndustry = industry_spinner.getSelectedItem().toString();
                 
			//filter companies by Industry and country
            companyAdapter.filterCompanyList(searchedIndustry, searchedCountry);
            
			return null;
		}

		private OnClickListener closeDialog() {
			// TODO Auto-generated method stub
			
	        // Close dialog
			dialog.dismiss();
			return null;
		}
		
		private OnClickListener setCompResultNumber() {

        	// Get Companies Results Number
            if (companies_list_results_count != null)
            	companies_list_results_count.setText("Results : " + String.valueOf(companyAdapter.getCount()) + " companies...");

            return null;
		}

	
}
