package com.kaassa.business.views;

import java.util.ArrayList;
import java.util.List;

import com.kaassa.business.R;
import com.kaassa.business.controllers.TabsPagerAdapter;
import com.kaassa.business.models.Company;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CompanyDetail3 extends FragmentActivity implements OnClickListener {
    static final int NUM_ITEMS = 2;

    TabsPagerAdapter mAdapter;

    ViewPager mPager;
    
	List<String> executivesName = new ArrayList<String>();
	List<String> subsidiariesName = new ArrayList<String>();
	Company selectedCompany;
	
    SubsidiaryFragment subsidiaryFragment = new SubsidiaryFragment();
    ExecutiveFragment executiveFragment = new ExecutiveFragment();
	
	Button goto_last;
	Button goto_first;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
   	 	//Get the selected company from "CompanyList View"
        selectedCompany = getIntent().getParcelableExtra("com.kaassa.business.controllers.company");
    
        
        Bundle bundle = new Bundle();
        bundle.putParcelable("selectedCompany", selectedCompany);
        // set Fragmentclass Arguments
        executiveFragment.setArguments(bundle);
        
        executiveFragment.setListExecutive(selectedCompany.getExecutives());
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companydetail3);
        


        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);


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

		  for (int i = 0; i < selectedCompany.getExecutives().size() ; i++)
		  {
			  executivesName.add(selectedCompany.getExecutives().get(i).getFirstname() + " " + selectedCompany.getExecutives().get(i).getLastname());
		  }
		  		  
		  //Get Name of Subsidiaries
		  for (int i = 0; i < selectedCompany.getSubsidiaries().size() ; i++)
		  {
			  subsidiariesName.add(selectedCompany.getSubsidiaries().get(i).getName());	
		  }
			
        // Watch for button clicks.
        goto_first = (Button)findViewById(R.id.goto_first);
        goto_first.setOnClickListener(this);
        
        goto_last = (Button)findViewById(R.id.goto_last);
        goto_last.setOnClickListener(this);
        

    }
    
    

	@Override
	public void onClick(View v) 
	{
		switch(v.getId()){
		case R.id.goto_first:
		
	        mPager.setCurrentItem(0);

	        executiveFragment = (ExecutiveFragment) mAdapter.getItem(0);
	       // executiveFragment.setListExecutive2(executivesName);
	        

	        
			break;
		
		case R.id.goto_last:
		
	        mPager.setCurrentItem(NUM_ITEMS-1);

	        subsidiaryFragment = (SubsidiaryFragment) mAdapter.getItem(1);
	      //  subsidiaryFragment.setListSubsidiary2(subsidiariesName);
		
			break;
		}

	}
	
}
