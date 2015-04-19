	package com.kaassa.business.controllers;

import java.util.ArrayList;
import java.util.List;

import com.kaassa.business.R;
import com.kaassa.business.models.Company;
import com.kaassa.business.controllers.CallKaassaBusinessWS;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CompanyAdapter extends BaseAdapter {

	
	private List<Company> companiesList = new ArrayList<Company>();

	// Get Companies list
	public CompanyAdapter() {
		
		CallKaassaBusinessWS callKaassaWS = new CallKaassaBusinessWS();
		companiesList = callKaassaWS.getCompaniesList();
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return companiesList.size();
	}

	@Override
	public Company getItem(int index) {
		// TODO Auto-generated method stub
		return companiesList.get(index);
	}

	@Override
	public long getItemId(int index) {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public View getView(int index, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		if (view == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.companyitemview, parent, false);
		}

		Company company = companiesList.get(index);
		
		TextView company_name = (TextView)view.findViewById(R.id.company_name);
		company_name.setText(company.getName());
		TextView location_city_and_country_name = (TextView)view.findViewById(R.id.location_city_and_country_name);
		location_city_and_country_name.setText(company.getLocation().getCity().getName() + " - " + company.getLocation().getCountry().getNameEn());
		TextView industry_name_en = (TextView)view.findViewById(R.id.industry_name_en);
		industry_name_en.setText(company.getIndustry().getNameEn());
		TextView count_executives = (TextView)view.findViewById(R.id.count_executives);
		count_executives.setText(String.valueOf(company.getCountExecutives()));

		return view;
		
	}

}
