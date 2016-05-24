package com.android.regional;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Info extends Activity{
	Button touristInfo,firstaidInfo;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.info);
	        touristInfo=(Button)findViewById(R.id.touristInfo);
	        firstaidInfo=(Button)findViewById(R.id.firstaidInfo);
	        
	        touristInfo.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(getBaseContext(), TouristInfo.class));
				}
			});
	        
	        firstaidInfo.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
				startActivity(new Intent(getBaseContext(), FirstAidInfo.class));	
				}
			});
	 }
}
