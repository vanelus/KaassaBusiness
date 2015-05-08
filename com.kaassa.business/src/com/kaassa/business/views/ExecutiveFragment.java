package com.kaassa.business.views;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kaassa.business.R;
import com.kaassa.business.models.Company;
import com.kaassa.business.models.Executive;

public class ExecutiveFragment extends ListFragment 
{
	protected Activity mActivity;
	protected ListView executives_list;
	
 
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	 Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 View view = inflater.inflate(R.layout.executive_fragment, container, false);	  
	 executives_list = (ListView) view.findViewById (android.R.id.list);
	   
	 return view;
	 }

	
    @Override
    public void onActivityCreated(Bundle saveInstanceState)
    {
        super.onActivityCreated(saveInstanceState);
        mActivity = getActivity(); 
        
        Company selectedCompany;
        if (getArguments() != null)
        {
        	selectedCompany = getArguments().getParcelable("selectedCompany");
            setListExecutive(selectedCompany.getExecutives(),mActivity);

        }

    }


	 public void setListExecutive(List<Executive> executives, Activity mActivity) 
	 {		  
		 
		  //Get Name of Subsidiaries
		  List<String> executivesName = new ArrayList<String>();
		  for (int i = 0; i < executives.size() ; i++)
		  {
			  executivesName.add(executives.get(i).getFirstname() + " " + executives.get(i).getLastname());
		  }
		  ArrayAdapter<String> listExecutiveAdapter = new ArrayAdapter<String>(mActivity, R.layout.listviewitem_executives, executivesName);
		  executives_list.setAdapter(listExecutiveAdapter);
	 }
	 

}
