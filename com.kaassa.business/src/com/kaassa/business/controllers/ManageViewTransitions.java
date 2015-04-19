package com.kaassa.business.controllers;

import com.kaassa.business.views.CompanyList;
import com.kaassa.business.views.HomePage;

import android.content.Context;
import android.content.Intent;

public class ManageViewTransitions {

	public void HomepageToCompanylist(Context context)
	{
        Intent intent = new Intent(context, CompanyList.class);
        context.startActivity(intent);
		
	}
	
}
