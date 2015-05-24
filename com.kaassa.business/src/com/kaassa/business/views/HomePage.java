package com.kaassa.business.views;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.kaassa.business.R;
import com.kaassa.business.controllers.CallKaassaBusinessWS;
import com.kaassa.business.controllers.ManageViewTransitions;

public class HomePage extends Activity implements OnClickListener 
{
	Button search_company;
	Button search_executive;
	Dialog dialog;
	
	CallKaassaBusinessWS callKaassaWS = new CallKaassaBusinessWS();
	ManageViewTransitions manageView = new ManageViewTransitions();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		
		search_company = (Button)findViewById(R.id.btn_search_company);
		
		search_company.setOnClickListener(this);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
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
	           	// Display contact us Dialog
				displayContactusDialog();
				
				return true;
		    default:
		        return super.onOptionsItemSelected(item);
		        
		}
            
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		//check wether the search concern Company or Executive
		RadioGroup rg_search_choice = (RadioGroup) findViewById(R.id.radio_group_search_choice);
		
		// radio button "company" is checked
		if (rg_search_choice.getCheckedRadioButtonId() == R.id.radio_group_search_choice_company)
		{
			//Call KaassaBusiness Web Service to Get Companies list
			callKaassaWS.getJsonData("", v.getContext());
			
			// Call the Transition method From the current view to "Companies List View"
			manageView.HomepageToCompanylist(v.getContext());
		}
		// radio button "executive" is checked
		else
		{
			//Call KaassaBusiness Web Service to Get Executives list
			callKaassaWS.getJsonData("", v.getContext());
			
			// Call the Transition method From the current view to "Executives List View"
			manageView.HomepageToExecutivelist(v.getContext());
		}

	}
	
	private void displayContactusDialog() 
	{
		// TODO Auto-generated method stub
		//Display a dialog to filter the hotellist	
		dialog = new Dialog(this);
		
        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog_sendmessage);
        
        // Set dialog title
        dialog.setTitle(R.string.menu_homepage_contactus);
        
        //Get Message Items
        EditText name_edittext = (EditText)dialog.findViewById(R.id.contact_us_name_edittext);
        EditText email_edittext = (EditText)dialog.findViewById(R.id.contact_us_email_edittext);
        EditText subject_edittext = (EditText)dialog.findViewById(R.id.contact_us_subject_edittext);
        EditText message_edittext = (EditText)dialog.findViewById(R.id.contact_us_message_edittext);
        Button home_button = (Button)dialog.findViewById(R.id.contact_us_home_button);
        Button send_button = (Button)dialog.findViewById(R.id.contact_us_send_button);
        
        // Display the dialog filter
        dialog.show();        
        
        OnClickListener dialogContactus = new OnClickListener() {
  	       @Override
  	       public void onClick(View v) 
  	       {
  	         // TODO Auto-generated method stub
  	   		switch(v.getId())
  			{
  				case R.id.contact_us_home_button:	
  					closeDialog();
  					break;
  				
  				case R.id.contact_us_send_button:
  					leaveusamessage();
  			        break;
  			}
  	       }
         };
         
		// if decline button is clicked, close the custom dialog
        home_button.setOnClickListener(dialogContactus);
        send_button.setOnClickListener(dialogContactus);        
        
	}

	private OnClickListener leaveusamessage() {
		// TODO Auto-generated method stub
		
        // Close dialog
		dialog.dismiss();
        
		return null;
	}

	private OnClickListener closeDialog() {
		// TODO Auto-generated method stub
		
        // Close dialog
		dialog.dismiss();
		return null;
	}

	
	

			
}
