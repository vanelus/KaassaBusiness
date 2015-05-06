package com.kaassa.business.views;

import java.util.ArrayList;
import java.util.List;

import com.kaassa.business.R;
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
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ExecutiveFragment extends ListFragment 
{
	protected Activity mActivity;
	protected ListView executives_list;
	protected List<String> executives ;
	
    @Override
    public void onAttach(Activity act)
    {
        super.onAttach(act);
    }
 
    @Override
    public void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        Company selectedCompany ;
		if (getArguments() != null)
        	selectedCompany = getArguments().getParcelable("selectedCompany");
        
    }
 
    @Override
    public void onActivityCreated(Bundle saveInstanceState)
    {
        super.onActivityCreated(saveInstanceState);
        mActivity = getActivity(); 
        
        Company selectedCompany;
        if (saveInstanceState != null)
        	selectedCompany = saveInstanceState.getParcelable("selectedCompany");
		
//		 
//		ArrayAdapter<String> listExecutiveAdapter = new ArrayAdapter<String>(mActivity, R.layout.listviewitem_executives, selectedCompany.getName());
//		executives_list.setAdapter(listExecutiveAdapter);
        
        //setListExecutive(selectedCompany.getExecutives() , mActivity);
    }
	 
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("selectedCompany", mCurCheckPosition);
    }
	
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	 Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 View view = inflater.inflate(R.layout.executive_fragment, container, false);
	  
	 executives_list = (ListView) view.findViewById (android.R.id.list);
	 

	  
	 return view;
	 }


	 public void setListExecutive(List<Executive> executives, Activity mActivity) 
	 {		  
		 
		  //Get Name of Subsidiaries
		  List<String> executivesName = new ArrayList<String>();
		  for (int i = 0; i < executives.size() ; i++)
		  {
			  executivesName.add(executives.get(i).getLastname());
		  }
		  ArrayAdapter<String> listExecutiveAdapter = new ArrayAdapter<String>(mActivity, R.layout.listviewitem_executives, executivesName);
		  executives_list.setAdapter(listExecutiveAdapter);
	 }
	 
	 
	 public void setListExecutive2(List<String> executives, Activity mActivity) 
	 {
		  ArrayAdapter<String> listExecutiveAdapter = new ArrayAdapter<String>(mActivity, R.layout.listviewitem_executives, executives);
		  executives_list.setAdapter(listExecutiveAdapter);
	 }
}
