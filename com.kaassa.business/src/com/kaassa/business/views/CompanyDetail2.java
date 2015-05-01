package com.kaassa.business.views;

import java.util.ArrayList;
import java.util.List;
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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CompanyDetail2 extends Activity {


	 ManageViewTransitions manageView = new ManageViewTransitions();
	
	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.companydetail2);
	        
	   	 	//Get the selected company from "CompanyList View"
	        Company selectedCompany = getIntent().getParcelableExtra("com.kaassa.business.controllers.company");
	        
	        // set Company Principal fields
				TextView company_name = (TextView)findViewById(R.id.company_name);
				company_name.setText(selectedCompany.getName());
				TextView location_city_and_country_name = (TextView)findViewById(R.id.location_city_and_country_name);
				location_city_and_country_name.setText(selectedCompany.getLocation().getCity().getName() + " - " + selectedCompany.getLocation().getCountry().getNameEn());
				TextView industry_name_en = (TextView)findViewById(R.id.industry_name_en);
				industry_name_en.setText(selectedCompany.getIndustry().getNameEn());
				TextView count_executives = (TextView)findViewById(R.id.count_executives);
				count_executives.setText(String.valueOf(selectedCompany.getCountExecutives()));
	        
				
				TextView contact_email = (TextView)findViewById(R.id.contact_email);
				TextView contact_phone = (TextView)findViewById(R.id.contact_phone);
				TextView slogan = (TextView)findViewById(R.id.slogan);
				
				contact_email.setText(selectedCompany.getContact().getEmail());
				contact_phone.setText(selectedCompany.getContact().getPhoneOne());
				slogan.setText(selectedCompany.getslogan());
	        
			  //Get Name of Executives
			  List<String> executivesName = new ArrayList<String>();
			  for (int i = 0; i < selectedCompany.getExecutives().size() ; i++)
			  {
				  executivesName.add(selectedCompany.getExecutives().get(i).getFirstname() + " " + selectedCompany.getExecutives().get(i).getLastname());
			  }
			  ArrayAdapter<String> executivesAdapter = new ArrayAdapter<String>(this, R.layout.listviewitem_executives, executivesName);
			  
			  
			  //Get Name of Subsidiaries
			  List<String> subsidiariesName = new ArrayList<String>();
			  for (int i = 0; i < selectedCompany.getSubsidiaries().size() ; i++)
			  {
				  subsidiariesName.add(selectedCompany.getSubsidiaries().get(i).getName());	
			  }
			  ArrayAdapter<String> subsidiariesAdapter = new ArrayAdapter<String>(this, R.layout.listviewitem_executives, subsidiariesName);
	        
		        ListView subsidiaries_list = (ListView)findViewById(R.id.subsidiaries_list);
		        ListView executives_list = (ListView)findViewById(R.id.executives_list);
		        
		        
		        
		        executives_list.setAdapter(executivesAdapter);
		        subsidiaries_list.setAdapter(subsidiariesAdapter);
		        
		        TextView executives_list_title = new TextView(getBaseContext());
		        executives_list_title.setText("Executives Tab");
		        
		        TextView subsidiaries_list_title = new TextView(getBaseContext());
		        subsidiaries_list_title.setText("Subsidiaries Tab");

		        subsidiaries_list.addHeaderView(subsidiaries_list_title);
		        executives_list.addHeaderView(executives_list_title);
	    	

	    	
	    }
	
}
