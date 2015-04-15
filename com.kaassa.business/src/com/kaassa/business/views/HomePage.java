package com.kaassa.business.views;


import java.util.ArrayList;
import java.util.List;

import com.kaassa.business.R;
import com.kaassa.business.controllers.CallKaassaBusinessWS;
import com.kaassa.business.models.Company;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomePage extends Activity implements OnClickListener 
{
	Button search_company;
	Button search_executive;
	
	CallKaassaBusinessWS callKaassaWS = new CallKaassaBusinessWS();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		
		search_company = (Button)findViewById(R.id.btn_search_company);
		search_executive = (Button)findViewById(R.id.btn_search_executive);
		
		search_company.setOnClickListener(this);
		search_executive.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.homepagemenu, menu);
			 
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		switch(id) {
			case R.id.action_settings:
						
				// 1. Instantiate an AlertDialog.AboutKaassa_dialog with its constructor
				AlertDialog.Builder AboutKaassa_dialog = new AlertDialog.Builder(HomePage.this);

				// 2. Chain together various setter methods to set the dialog characteristics
				AboutKaassa_dialog.setMessage(R.string.AboutKaassa_dialog_message);
				AboutKaassa_dialog.setTitle(R.string.AboutKaassa_dialog_title);
				
				AboutKaassa_dialog.setNegativeButton(R.string.AboutKaassa_dialog_ok, new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			               // User cancelled the dialog
			        	   dialog.dismiss();
			           }
			       });

				// 3. Get the AboutKaassa_dialog from create()
				AlertDialog dialog = AboutKaassa_dialog.create();
				


				//Close dialog		
				dialog.show();

	    	    return true;
			case R.id.action_leaveusmessage:
	           	
              //Add the following lines
            	Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, "test@kassa.com");
            	
             // Verify that the intent will resolve to an activity
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(i, "Choose an Email client :"));
                }
				return true;
		    default:
		        return super.onOptionsItemSelected(item);
		        
		}
            
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId())
		{
			case R.id.btn_search_company:
				List<Company> companiesList = new ArrayList<Company>();
				
				companiesList = callKaassaWS.getJsonData("", v.getContext());
				
			break;
			
			case R.id.btn_search_executive:
				
			break;
		}

	}

			
}
