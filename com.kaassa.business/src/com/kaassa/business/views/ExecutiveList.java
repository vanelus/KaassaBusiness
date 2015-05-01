package com.kaassa.business.views;

import com.kaassa.business.R;
import com.kaassa.business.controllers.ExecutiveAdapter;
import com.kaassa.business.controllers.ManageViewTransitions;
import com.kaassa.business.models.Company;
import com.kaassa.business.models.Executive;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class ExecutiveList extends Activity {

	 ExecutiveAdapter executiveAdapter;

	 ManageViewTransitions manageView = new ManageViewTransitions();
	
	 public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.executivepage);
	        
	        ListView executives_list = (ListView)findViewById(R.id.executives_list);
	        executiveAdapter = new ExecutiveAdapter();
	        executives_list.setAdapter(executiveAdapter);
	        
	        //Set executive list results count
	        TextView executives_list_results_count = (TextView)findViewById(R.id.executives_list_results_count);
	        executives_list_results_count.setText("Results : " + executives_list.getCount() + " executives...");
	        
	        
	    	//Handle click on executive from "Executives List"
	        executives_list.setOnItemClickListener(new AdapterView.OnItemClickListener() 
    		{
    			@Override
    			public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {


    	    	    
    	    	    // Get Hotel "behind" the clicked item
    				Company company =  (Company) arg0.getAdapter().getItem(position);
    				
    				// Call the Transition method From the current view to "Companies List View"
    				manageView.ExecutivelistToCompanydetail(v.getContext(), company);
    	    	    
      

    	    	}
    		});
	    }
	        
}
