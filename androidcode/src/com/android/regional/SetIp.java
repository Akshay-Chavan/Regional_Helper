package com.android.regional;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.json.JSONObject;

import com.android.databse.DBAdaptern;
import com.google.android.maps.GeoPoint;

import android.app.Activity;
import android.content.Context;
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
import android.widget.EditText;
import android.widget.Toast;

public class SetIp extends Activity implements LocationListener{
	LocationManager locationManager;
	private Location finalLocation;
	private double latitude=0,longitude=0;
	JSONObject json;
	Button setip;
	EditText iptext;
	String msg;
	DBAdaptern db=new DBAdaptern(this);
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.setip);
	        setip=(Button)findViewById(R.id.setip);
	        iptext=(EditText)findViewById(R.id.iptext);
	        
	        
	        //Used to set IP
	        setip.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(iptext.getText().toString().equals(""))
					{
						Toast.makeText(getBaseContext(), "Pls enter new IP", Toast.LENGTH_LONG).show();
					}
					else
					{
						db.open();
						db.deleteIP();
						db.insertIP(iptext.getText().toString());
						db.close();
						iptext.setText("");
					}
					
				}
			});
	        
	 }
	 
	 
	 //Used to get current location
	 public void getLocation()
	 {
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
		
		SmsManager sms=SmsManager.getDefault();
		sms.sendTextMessage("+919763663112", null, msg, null, null);
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
	
	//Used to convert Geopoint to address
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
