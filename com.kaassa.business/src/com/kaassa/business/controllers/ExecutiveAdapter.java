package com.kaassa.business.controllers;

import java.util.ArrayList;
import java.util.List;

import com.kaassa.business.R;
import com.kaassa.business.models.Company;
import com.kaassa.business.models.Executive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ExecutiveAdapter extends BaseAdapter {

	private List<Company> companiesList = new ArrayList<Company>();

	// Get Companies list
	public ExecutiveAdapter() {
		
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
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int index, View view, ViewGroup parent) {
		// TODO Auto-generated method stub


		if (view == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.executiveitemview, parent, false);
		}

		Company company = companiesList.get(index);
		
		TextView executive_firstandlast_name = (TextView)view.findViewById(R.id.executive_firstandlast_name);
		TextView executive_function = (TextView)view.findViewById(R.id.executive_function);

		//check if an executive exists in a company?
		if (company.getExecutives().size() > 0)
		{
			if (company.getExecutives().get(0).getGender().equals("male"))
				executive_firstandlast_name.setText("Mr. " + company.getExecutives().get(0).getFirstname() + " " + company.getExecutives().get(0).getLastname());
			else
				executive_firstandlast_name.setText("Ms. " + company.getExecutives().get(0).getFirstname() + " " + company.getExecutives().get(0).getLastname());
			executive_function.setText(company.getExecutives().get(0).getTitleEn() + " " + company.getName() + " (" + company.getLocation().getCountry().getNameEn() + ")" );		
		}
		return view;
	}

}
