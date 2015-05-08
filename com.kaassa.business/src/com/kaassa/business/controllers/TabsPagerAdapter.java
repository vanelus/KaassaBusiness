package com.kaassa.business.controllers;

import com.kaassa.business.models.Company;
import com.kaassa.business.views.ExecutiveFragment;
import com.kaassa.business.views.SubsidiaryFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public Company selectedCompany;
	
	
	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {
		// TODO Auto-generated method stub
	     switch (index) {
	        case 0:
	            // Executives fragment activity
	        	ExecutiveFragment executiveFragment = new ExecutiveFragment();
	            Bundle executiveFragment_args = new Bundle();
	            executiveFragment_args.putParcelable("selectedCompany", selectedCompany);
	            executiveFragment.setArguments(executiveFragment_args);
	            
	            return executiveFragment;
	            
	        case 1:
	            // Subsidiaries fragment activity
	        	SubsidiaryFragment subsidiaryFragment = new SubsidiaryFragment();
	            Bundle subsidiaryFragment_args = new Bundle();
	            subsidiaryFragment_args.putParcelable("selectedCompany", selectedCompany);
	            subsidiaryFragment.setArguments(subsidiaryFragment_args);
	            return subsidiaryFragment ;
	     }
	        return null;	
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	
    // Returns the selected Company
    public void setSelectedCompany(Company company) {
    	this.selectedCompany = company;
    }

}
