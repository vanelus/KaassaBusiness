package com.kaassa.business.controllers;

import com.kaassa.business.models.Company;
import com.kaassa.business.views.CompanyDetail;
import com.kaassa.business.views.CompanyDetail2;
import com.kaassa.business.views.CompanyDetail3;
import com.kaassa.business.views.CompanyList;
import com.kaassa.business.views.ExecutiveList;
import com.kaassa.business.views.HomePage;

import android.content.Context;
import android.content.Intent;

public class ManageViewTransitions {

	public void HomepageToCompanylist(Context context)
	{
        Intent intent = new Intent(context, CompanyList.class);
        context.startActivity(intent);
		
	}

	public void HomepageToExecutivelist(Context context)
	{
        Intent intent = new Intent(context, ExecutiveList.class);
        context.startActivity(intent);
		
	}
	
	public void CompanylistToCompanydetail(Context context, Company company) {
		// TODO Auto-generated method stub
		
		
	    Intent intent = new Intent(context,CompanyDetail3.class);
	    
	    intent.putExtra("com.kaassa.business.controllers.company",company);
	    
	    context.startActivity(intent);
	}
	
	public void ExecutivelistToCompanydetail(Context context, Company company) {
		// TODO Auto-generated method stub
		
		
	    Intent intent = new Intent(context,CompanyDetail.class);
	    
	    intent.putExtra("com.kaassa.business.controllers.company",company);
	    
	    context.startActivity(intent);
	}
	
	
	
}
