package com.android.regional;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Timer;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.databse.DBAdaptern;
import com.android.databse.DBUserDetails;
import com.google.android.maps.GeoPoint;




import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TextLocationActivity extends Activity implements LocationListener{
	LocationManager locationManager;
	Button btn;
	TextView txtlocation;
	Timer timer1;
	private Location finalLocation;
	private double latitude=0,longitude=0;
	String msg,ip,userName,mail,usercontact,city,service;
	int flag;
	Cursor cursor,c;
	JSONObject json;
	DBAdaptern db=new DBAdaptern(this);
	DBUserDetails user=new DBUserDetails(this);
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textlocation);
        btn=(Button)findViewById(R.id.button1);
        txtlocation=(TextView)findViewById(R.id.textlocation);
        
        Bundle bundle=getIntent().getExtras();
        flag=bundle.getInt("flag");
        getLocation();
        

        
        btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
    }
    
    //Used to get Current Location
    public void getLocation(){
    	
    
 		ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
 		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

 		if(networkInfo == null || !networkInfo.isConnectedOrConnecting()) {			
 			Toast.makeText(getBaseContext(), "Pls turn on your internet", Toast.LENGTH_LONG).show();			
 		}
 		locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

 		if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
 			Toast.makeText(getBaseContext(), "Pls enable gps access", Toast.LENGTH_LONG).show();
 		}
 		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
 		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

 	}
	public void onLocationChanged(Location location) {
		locationManager.removeUpdates(this);
		finalLocation = location;
		latitude = finalLocation.getLatitude();
		longitude = finalLocation.getLongitude();
		
		Toast.makeText(getBaseContext(), "Lat:"+latitude+"Lon:"+longitude, Toast.LENGTH_LONG).show();
		
		GeoPoint p=new GeoPoint((int)(latitude*1E6), (int)(longitude*1E6));
		String str=ConvertPointToLocation(p);
		msg=("Pls help me out my current location is\n" +
				str);
		
		switch (flag) {
		case 1:
			service="ambulance";
			db.open();
			c=db.getIP();
			if(c.moveToFirst())
			{
				do
				{
					ip=c.getString(0);
				}while(c.moveToNext());
			}
			db.close();
			
			user.open();
			cursor=user.getUserDetails();
			if(cursor.moveToFirst()){
				do{
					usercontact=cursor.getString(0);
					userName=cursor.getString(1);
					city=cursor.getString(2);
					mail=cursor.getString(3);
				}while(cursor.moveToNext());
			}
			user.close();
			
			json=new JSONObject();
			try {
				json.put("latitude", latitude);
				json.put("longitude", longitude);
				json.put("service", service);
				json.put("ip", ip);
				json.put("name",userName );
				json.put("contact", usercontact);
				json.put("city", city);
				json.put("email", mail);
				json.put("requestid", "ambulance");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    new ConnectToServer().SendToServer(json);
		    finish();
		    break;
			
		case 2:
			SmsManager sms=SmsManager.getDefault();
			sms.sendTextMessage("+918149581110", null, msg, null, null);
			finish();
			break;
			
		case 3:
			service="firebrigade";
			db.open();
			c=db.getIP();
			if(c.moveToFirst())
			{
				do
				{
					ip=c.getString(0);
				}while(c.moveToNext());
			}
			db.close();
			
			user.open();
			cursor=user.getUserDetails();
			if(cursor.moveToFirst()){
				do{
					usercontact=cursor.getString(0);
					userName=cursor.getString(1);
					city=cursor.getString(2);
					mail=cursor.getString(3);
				}while(cursor.moveToNext());
			}
			user.close();
			
			json=new JSONObject();
			try {
				json.put("latitude", latitude);
				json.put("longitude", longitude);
				json.put("service", service);
				json.put("ip", ip);
				json.put("name",userName );
				json.put("contact", usercontact);
				json.put("city", city);
				json.put("email", mail);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    new ConnectToServer().SendToServer(json);
		    finish();
		    break;
		    
		case 4:
			service="police";
			db.open();
			c=db.getIP();
			if(c.moveToFirst())
			{
				do
				{
					ip=c.getString(0);
				}while(c.moveToNext());
			}
			db.close();
			
			user.open();
			cursor=user.getUserDetails();
			if(cursor.moveToFirst()){
				do{
					usercontact=cursor.getString(0);
					userName=cursor.getString(1);
					city=cursor.getString(2);
					mail=cursor.getString(3);
				}while(cursor.moveToNext());
			}
			user.close();
			
			json=new JSONObject();
			try {
				json.put("latitude", latitude);
				json.put("longitude", longitude);
				json.put("service", service);
				json.put("ip", ip);
				json.put("name",userName );
				json.put("contact", usercontact);
				json.put("city", city);
				json.put("email", mail);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    new ConnectToServer().SendToServer(json);
		    finish();
		    break;

		default:
			break;
		}
		
		Toast.makeText(getBaseContext(), ""+msg, Toast.LENGTH_LONG).show();
		
		
		// TODO Auto-generated method stub
		
	}
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
	//Used to convert current Geopoint to address.
	public String ConvertPointToLocation(GeoPoint point) 
	{   
	    String address = "";
	    Geocoder geoCoder = new Geocoder(
	            getBaseContext(), Locale.getDefault());
	    try {
	        List<Address> addresses = geoCoder.getFromLocation(
	            point.getLatitudeE6()  / 1E6,
	            point.getLongitudeE6() / 1E6, 1);

	        if (addresses.size() > 0) {
	            for (int index = 0; index < addresses.get(0).getMaxAddressLineIndex(); index++)
	                address += addresses.get(0).getAddressLine(index) + " ";
	            Log.i(address, address);
	        }

	    }
	    catch (IOException e) {                
	        e.printStackTrace();
	    }  
	    return address;
	}
}