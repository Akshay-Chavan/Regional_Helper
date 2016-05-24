package com.android.regional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

public class ConnectToServer {
	
	String jsonString=null,msg;
	JSONObject jsonloginString;
	URL sourceUrl;
	BufferedReader br;
	InputStream is;
	String ip;
	
	/*
	 * Method to connect to server and send data via JSONObject
	 * Accepts single parameter of JSONObject and returns a String object received from server
	 */
	public String SendToServer(JSONObject jsonlogin)
	{
		  try {
			ip=jsonlogin.getString("ip");
			System.out.println(ip);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  jsonString=jsonlogin.toString();
		  jsonString=URLEncoder.encode(jsonString);
		
		  try {
                sourceUrl = new URL("http://"+ip+"/RegionalHelperWeb/receivefromclient.jsp?jsonString="+jsonString);//url of server

				is=sourceUrl.openStream();
				if(is.available() > 0){
					br=new BufferedReader(new InputStreamReader(is));
					msg=br.readLine();
					return msg;
				}

			} catch (MalformedURLException e) {
				System.out.println("connection exception");
				//e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(is!=null)
						is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;

}

}
