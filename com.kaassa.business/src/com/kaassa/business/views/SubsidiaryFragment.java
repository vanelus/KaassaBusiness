package com.kaassa.business.views;

import java.util.ArrayList;
import java.util.List;

import com.kaassa.business.R;
import com.kaassa.business.models.Company;
import com.kaassa.business.models.Executive;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SubsidiaryFragment extends ListFragment {
	
	ListView subsidiaries_list;
	Context fragmentActivty;
	
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,	 Bundle savedInstanceState) 
	{
		 // TODO Auto-generated method stub
		 View view = inflater.inflate(R.layout.subsidiary_fragment, container, false);

		 return view;
	 }
	
	 public void onActivityCreated(LayoutInflater inflater, ViewGroup container,
	 Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	  
		 subsidiaries_list = (ListView) getListView().findViewById (android.R.id.list);
		 fragmentActivty  =  getActivity();
		 Company selectedCompany = getArguments().getParcelable("selectedCompany");  
	  
	 }
	 

	 
	 
	 public void setListSubsidiary(List<Company> subsidiaries) 
	 {
		  
		 ListView subsidiaries_list = (ListView) getListView().findViewById (android.R.id.list);
		  //Get Name of Subsidiaries
		  List<String> subsidiariesName = new ArrayList<String>();
		  for (int i = 0; i < subsidiaries.size() ; i++)
		  {
			  subsidiariesName.add(subsidiaries.get(i).getName());
		  }
		  ArrayAdapter<String> listExecutiveAdapter = new ArrayAdapter<String>(getActivity(), R.layout.listviewitem_executives, subsidiariesName);
		  subsidiaries_list.setAdapter(listExecutiveAdapter);
	 }
	 
	 public void setListSubsidiary2(List<String> subsidiaries) 
	 {	
		 ListView subsidiaries_list = (ListView) getListView().findViewById (android.R.id.list);
		 if (fragmentActivty != null){
		  ArrayAdapter<String> listExecutiveAdapter = new ArrayAdapter<String>(fragmentActivty, R.layout.listviewitem_executives, subsidiaries);
		  subsidiaries_list.setAdapter(listExecutiveAdapter);
		 }
		 
	 }
}
