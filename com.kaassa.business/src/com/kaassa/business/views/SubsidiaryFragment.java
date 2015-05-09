package com.kaassa.business.views;

import java.util.ArrayList;
import java.util.List;

import com.kaassa.business.R;
import com.kaassa.business.controllers.CompanyAdapter;
import com.kaassa.business.controllers.ManageViewTransitions;
import com.kaassa.business.models.Company;
import com.kaassa.business.models.Executive;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SubsidiaryFragment extends ListFragment {
		
	protected Activity mActivity;
	protected ListView subsidiaries_list;
	
	CompanyAdapter companyAdapter = new CompanyAdapter();
	ManageViewTransitions manageView = new ManageViewTransitions();
	
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,	 Bundle savedInstanceState) 
	{
		 // TODO Auto-generated method stub
		 View view = inflater.inflate(R.layout.subsidiary_fragment, container, false);
		 subsidiaries_list = (ListView) view.findViewById (android.R.id.list);
		 


		 return view;
	 }
	
	 public void onActivityCreated(Bundle saveInstanceState) 
	 {
		 // TODO Auto-generated method stub
		 super.onActivityCreated(saveInstanceState);

		 
		mActivity = getActivity(); 
		
		Company selectedCompany;
		if (getArguments() != null)
		{
			selectedCompany = getArguments().getParcelable("selectedCompany");
			setListSubsidiary(selectedCompany.getSubsidiaries(),mActivity);
		
		}
		
	    //Handle click on company from "Subsidiaries List" Fragment
		subsidiaries_list.setOnItemClickListener(new AdapterView.OnItemClickListener() 
 		{
 			@Override
 			public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
 	    	    
 	    	    // Get company name "behind" the clicked item
 				String companyName =  (String) arg0.getAdapter().getItem(position);
 				
 				if (companyName != null)
 				{
 	 				Company company = companyAdapter.getCompanyByName(companyName);

 	 				// Call the Transition method From the current view to "Companies List View"
 	 				manageView.SubsidiarylistToCompanydetail(v.getContext(), company);
 	 	    	    
 					
 				}

   

 	    	}
 		});
	  
	 }
	 	 
	 
	 public void setListSubsidiary(List<Company> subsidiaries, Activity mActivity) 
	 {
		  
		 ListView subsidiaries_list = (ListView) getListView().findViewById (android.R.id.list);
		  //Get Name of Subsidiaries
		  List<String> subsidiariesName = new ArrayList<String>();
		  for (int i = 0; i < subsidiaries.size() ; i++)
		  {
			  subsidiariesName.add(subsidiaries.get(i).getName());
		  }
		  ArrayAdapter<String> listExecutiveAdapter = new ArrayAdapter<String>(mActivity, R.layout.listviewitem_executives, subsidiariesName);
		  subsidiaries_list.setAdapter(listExecutiveAdapter);
	 }
	 

}
