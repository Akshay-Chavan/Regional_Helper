package com.android.regional;

import org.json.parser.JSONException;
import org.json.parser.JSONObject;

import com.android.databse.DBUserDetails;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class RegisterActivity extends Activity {

	private SharedPreferences prefs;
	private String prefname="Mypref";
	
	EditText nameEditText, mailEditText, numEditText,cityEditText;
	private static final String REGISTER = "register";
    
	DBUserDetails db=new DBUserDetails(this);
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
    
		nameEditText=(EditText)findViewById(R.id.etName);
		mailEditText=(EditText)findViewById(R.id.etEmail);
		numEditText=(EditText)findViewById(R.id.etMobile);
		cityEditText=(EditText)findViewById(R.id.etCity);
        
		((Button) findViewById(R.id.butRegister))
		.setOnClickListener(
		new View.OnClickListener() {
			
			public void onClick(View v) {
               
                
				String name=nameEditText.getText().toString().trim();

				String city=cityEditText.getText().toString().trim();

				String email=mailEditText.getText().toString().trim();

				String mobNumber=numEditText.getText().toString().trim();

				
					prefs = getSharedPreferences(prefname, MODE_PRIVATE);
					SharedPreferences.Editor editor = prefs.edit();
					
					editor.putBoolean(REGISTER, true);
					editor.commit();
                    
					String contact=mobNumber;
					
					db.open();
					long i=  db.insertUserDetails(contact, name, city, email);
					db.close();
					
					
					if(i>0){
						Toast.makeText(getBaseContext(),"Registered Successfully", Toast.LENGTH_LONG).show();
					}
					else{
						Toast.makeText(getBaseContext(),"Registered unuccessfully", Toast.LENGTH_LONG).show();
					}
					
					finish();
				

			}
		});
	}


}
