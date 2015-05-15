package com.kaassa.business.controllers;

import android.content.Context;
import android.content.Intent;

import com.kaassa.business.models.Company;
import com.kaassa.business.views.CompanyDetail;
import com.kaassa.business.views.CompanyList;
import com.kaassa.business.views.ExecutiveList;

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
		
		
	    Intent intent = new Intent(context,CompanyDetail.class);
	    
	    intent.putExtra("com.kaassa.business.controllers.company",company);
	    
	    context.startActivity(intent);
	}
	
	
	public void ExecutivelistToCompanydetail(Context context, Company company) {
		// TODO Auto-generated method stub
		
		
	    Intent intent = new Intent(context,CompanyDetail.class);
	    
	    intent.putExtra("com.kaassa.business.controllers.company",company);
	    
	    context.startActivity(intent);
	}

	public void SubsidiarylistToCompanydetail(Context context, Company company) {
		// TODO Auto-generated method stub
		
	    Intent intent = new Intent(context,CompanyDetail.class);
	    
	    intent.putExtra("com.kaassa.business.controllers.company",company);
	    
	    context.startActivity(intent);
		
	}
	
	
	
}
