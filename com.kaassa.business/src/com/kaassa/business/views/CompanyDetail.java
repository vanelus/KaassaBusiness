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

public class CompanyDetail extends FragmentActivity implements OnClickListener {
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
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companydetail);
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        mAdapter.setSelectedCompany(selectedCompany);
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);


        // Get Company Principal fields view
		TextView company_name = (TextView)findViewById(R.id.company_name);
		TextView location_city_and_country_name = (TextView)findViewById(R.id.location_city_and_country_name);
		TextView industry_name_en = (TextView)findViewById(R.id.industry_name_en);
		TextView count_executives = (TextView)findViewById(R.id.count_executives);
		TextView contact_email = (TextView)findViewById(R.id.contact_email);
		TextView contact_phone = (TextView)findViewById(R.id.contact_phone);
		TextView slogan = (TextView)findViewById(R.id.slogan);
		
        // set Company Principal fields
		company_name.setText(selectedCompany.getName());
		location_city_and_country_name.setText(selectedCompany.getLocation().getCity().getName() + " - " + selectedCompany.getLocation().getCountry().getNameEn());
		industry_name_en.setText(selectedCompany.getIndustry().getNameEn());
		count_executives.setText(String.valueOf(selectedCompany.getCountExecutives()));
		contact_email.setText(selectedCompany.getContact().getEmail());
		contact_phone.setText(selectedCompany.getContact().getPhoneOne());
		slogan.setText(selectedCompany.getslogan());
        

        // Watch for button clicks.
        goto_first = (Button)findViewById(R.id.goto_first);
        goto_first.setOnClickListener(this);
        
        goto_last = (Button)findViewById(R.id.goto_last);
        goto_last.setOnClickListener(this);
        
    }
    
    

	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
			case R.id.goto_first:	
		        mPager.setCurrentItem(0);	        

				break;
			
			case R.id.goto_last:
		        mPager.setCurrentItem(NUM_ITEMS-1);
	
		        break;
			}

	}
	
}
