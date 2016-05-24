package com.android.regional;

import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegionalHelperActivity extends Activity {
	Button ambulance,sendSMS,firebrigade,police;
	JSONObject json;
	private SharedPreferences prefs;
	private String prefname="Mypref";
	private static final String REGISTER = "register";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ambulance=(Button)findViewById(R.id.ambulance);
        sendSMS=(Button)findViewById(R.id.callgroup);
        firebrigade=(Button)findViewById(R.id.firebrigade);
        police=(Button)findViewById(R.id.police);
        
        Display display = getWindowManager().getDefaultDisplay(); 
		int screenWidth = display.getWidth();
		android.view.ViewGroup.LayoutParams params = ambulance.getLayoutParams();
		
		params.height = screenWidth/2;
		params.width =  screenWidth/2;
		ambulance.setLayoutParams(params);
		sendSMS.setLayoutParams(params);
		firebrigade.setLayoutParams(params);
		police.setLayoutParams(params);
		
		
        //Used to call ambulance service
        ambulance.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if(isRegistered()){
				Intent i=new Intent(getApplication(), TextLocationActivity.class);
				i.putExtra("flag", 1);
				startActivity(i);
				}
				else{
					startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
				}
				// TODO Auto-generated method stub
				//startActivity(new Intent(getApplicationContext(), TextLocationActivity.class));
			}
		});
        
      //Used to call EmergencyCall service  
      sendSMS.setOnClickListener(new View.OnClickListener() {
  			
			public void onClick(View v) {
				if(isRegistered()){
				Intent i=new Intent(getApplication(), TextLocationActivity.class);
				i.putExtra("flag", 2);
				startActivity(i);
				}
				else{
					startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
				}
			}
		});
      
    //Used to call Firebrigade service
      firebrigade.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(isRegistered()){
			Intent i=new Intent(getApplication(), TextLocationActivity.class);
			i.putExtra("flag", 3);
			startActivity(i);
			}
			else{
				startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
			}
		}
	});
      
    //Used to call Police service
      police.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(isRegistered()){
				Intent i=new Intent(getApplication(), TextLocationActivity.class);
				i.putExtra("flag", 4);
				startActivity(i);
			}
			else{
				startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
			}
		}
	});
      
      
    }
    
    public boolean isRegistered() {
		prefs = getSharedPreferences(prefname, MODE_PRIVATE);
		if(prefs.getBoolean(REGISTER, false)){
			return true;
		}
		return false;
	}
    
    public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, "Settings").setIcon(R.drawable.setting);
		menu.add(0, 1, 1, "More");
		return true;
	}
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			startActivity(new Intent(getApplicationContext(), SetIp.class));
			break;
			
		case 1:
			startActivity(new Intent(getApplicationContext(), Info.class));
			break;	
			
		
		}
		
		return true; 
}
}