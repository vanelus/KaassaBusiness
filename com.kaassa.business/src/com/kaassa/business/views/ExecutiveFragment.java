package com.kaassa.business.views;

import java.util.ArrayList;
import java.util.List;

import com.kaassa.business.R;
import com.kaassa.business.models.Company;
import com.kaassa.business.models.Executive;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ExecutiveFragment extends ListFragment {
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	 Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 View view = inflater.inflate(R.layout.executive_fragment, container, false);
	  
//	  Company selectedCompany = this.getArguments().getParcelable("selectedCompany");
//	  setListExecutive(selectedCompany.getExecutives());
	  
	 return view;
	 }

	 public void setListExecutive(List<Executive> executives) 
	 {
		  ListView executives_list = (ListView) getView().findViewById (android.R.id.list);
		  
		  //Get Name of Subsidiaries
		  List<String> executivesName = new ArrayList<String>();
		  for (int i = 0; i < executives.size() ; i++)
		  {
			  executivesName.add(executives.get(i).getLastname());
		  }
		  ArrayAdapter<String> listExecutiveAdapter = new ArrayAdapter<String>(getActivity(), R.layout.listviewitem_executives, executivesName);
		  executives_list.setAdapter(listExecutiveAdapter);
	 }
}
