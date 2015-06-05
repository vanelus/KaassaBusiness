	package com.kaassa.business.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.kaassa.business.R;
import com.kaassa.business.models.Company;
import com.kaassa.business.controllers.CallKaassaBusinessWS;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author vanel njike
 *
 */
public class CompanyAdapter extends BaseAdapter {

	private int layoutType = 1;
	
	private List<Company> companiesList = new ArrayList<Company>();
	public List<String> industriesList = new ArrayList<String>();
	public	 List<String> countriesList = new ArrayList<String>();
	private List<Company> neverFilteredcompanies = new ArrayList<Company>();

	// Get Companies list
	public CompanyAdapter(ArrayList<Company> companies, int lType) {
		
		companiesList = companies;
		
		// Get the Company List Layout Type
		layoutType = lType;
		
		// Set countries list from companies result set
		setCountriesList(companiesList);
		// Set industries list from companies result set
		setIndustriesList(companiesList);
		
		neverFilteredcompanies = companiesList;
		
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
		
		if (layoutType == 1)
		{
			if (view == null) {
				LayoutInflater inflater = LayoutInflater.from(parent.getContext());
				view = inflater.inflate(R.layout.companyitemview, parent, false);
			}
	
			Company company = companiesList.get(index);
			
			TextView company_name = (TextView)view.findViewById(R.id.company_name);
			TextView industry_name_en = (TextView)view.findViewById(R.id.industry_name_en);
			TextView location_city_and_country_name = (TextView)view.findViewById(R.id.location_city_and_country_name);
			TextView count_executives = (TextView)view.findViewById(R.id.count_executives);
			
			company_name.setText(company.getName());
			location_city_and_country_name.setText(company.getLocation().getCity().getName() + " - " + company.getLocation().getAddress() + "(" + company.getLocation().getCountry().getNameEn() + ")");		
			industry_name_en.setText(company.getIndustry().getNameEn());
			count_executives.setText(String.valueOf(company.getCountExecutives()) + " executives");
		}
		
		if (layoutType == 2)
		{
			if (view == null) {
				LayoutInflater inflater = LayoutInflater.from(parent.getContext());
				view = inflater.inflate(R.layout.companyitemview2, parent, false);
			}
	
			Company company = companiesList.get(index);
			
			TextView company_name = (TextView)view.findViewById(R.id.company_name);
			TextView industry_name_en = (TextView)view.findViewById(R.id.industry_name_en);
			
			company_name.setText(company.getName());
			industry_name_en.setText(company.getIndustry().getNameEn());
		}

		return view;
		
	}
	
	/**
	 * Filter Companies By Industry or Country
	 * @param industry
	 * @param country
	 */
	public void filterCompanyList(String industry, String  country) 
	{
		
		List<Company> filteredCompanies = new ArrayList<Company>();
		
		 // case 1 0
		if (!industry.equals("") && country.equals(""))
		{
	        for (int i = 0; i < neverFilteredcompanies.size(); i++) 
	        {
	        	Company comp = neverFilteredcompanies.get(i);
	            if (comp.getIndustry().getNameEn().equals(industry))
	            	filteredCompanies.add(comp);
	        }
		}
		
		 // case 0 1
		if (industry.equals("") && !country.equals(""))
		{
	        for (int i = 0; i < neverFilteredcompanies.size(); i++) 
	        {
	        	Company comp = neverFilteredcompanies.get(i);
	            if (comp.getLocation().getCountry().getNameEn().equals(country))
	            	filteredCompanies.add(comp);
	        }
		}
		
		 // case 1 1
		if (!industry.equals("") && !country.equals(""))
		{
	        for (int i = 0; i < neverFilteredcompanies.size(); i++) 
	        {
	        	Company comp = neverFilteredcompanies.get(i);
	            if (comp.getIndustry().getNameEn().equals(industry) && comp.getLocation().getCountry().getNameEn().equals(country))
	            	filteredCompanies.add(comp);
	        }
		}
		
		 // case 0 0 
		if (industry.equals("") && country.equals(""))
		{
	        for (int i = 0; i < neverFilteredcompanies.size(); i++) 
	        {
	        	Company comp = neverFilteredcompanies.get(i);
	            filteredCompanies.add(comp);
	        }
		}

		companiesList = filteredCompanies;
		
		notifyDataSetChanged();

	}
	
	

	/**
	 * @param companiesList
	 * @param companyname
	 * @param myContext
	 */
	public void filterCompanyByName(String companyname, Context myContext) 
	{
		String searchedCompany = companyname.toLowerCase(Locale.getDefault());
		List<Company> filteredCompanies = new ArrayList<Company>();

		
        for (int i = 0; i < neverFilteredcompanies.size(); i++) 
        {
        	Company comp = neverFilteredcompanies.get(i);
            if (comp.getName().toLowerCase().startsWith(searchedCompany))
            	filteredCompanies.add(comp);
        }
        
        companiesList = filteredCompanies ;
		
		notifyDataSetChanged();
		

	}
	
	/**
	 * @param companiesList
	 */
	public void setIndustriesList(List<Company> companiesList)
	{
		industriesList.clear();
		//add default value
		industriesList.add("");
		
        for (int i = 0; i < companiesList.size(); i++) 
        {
        	if (!(industriesList.contains(companiesList.get(i).getIndustry().getNameEn())))
           	industriesList.add(companiesList.get(i).getIndustry().getNameEn());
        } 
	}
	
	
	/**
	 * @param companiesList
	 */
	public void setCountriesList(List<Company> companiesList)
	{
		countriesList.clear();
		//add default value
		countriesList.add("");
		
        for (int i = 0; i < companiesList.size(); i++) 
        {
        	if (!(countriesList.contains(companiesList.get(i).getLocation().getCountry().getNameEn())))
        		countriesList.add(companiesList.get(i).getLocation().getCountry().getNameEn());
        } 
		
	}
	
	public Company getCompanyByName(String companyName)
	{
		Company company = null;
		
        for (int i = 0; i < companiesList.size(); i++) 
        {
        	if (companiesList.get(i).getName().equals(companyName))
        	{
        		company = companiesList.get(i);
        		
        		//set parent slug on subsidiary
        		company.setParentCompanySlug(companiesList.get(i).getParentCompanySlug());
        	}
        } 
		
		return company;
		
	}
	
	public Company getCompanyBySlug(String companySlug)
	{
		Company company = null;
		
        for (int i = 0; i < companiesList.size(); i++) 
        {
        	if (companiesList.get(i).getSlug().equals(companySlug))
        	{
        		company = companiesList.get(i);
        	}
        } 
		
		return company;
		
	}
	
	
		

}
