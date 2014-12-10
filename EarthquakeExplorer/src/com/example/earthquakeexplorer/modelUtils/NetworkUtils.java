package com.example.earthquakeexplorer.modelUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkUtils {
	
	private static final String tag = "NetworkUtils";
	public static final String dataSrc = 
			"http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_month.geojson";
	
	/* Starts from non-UI thread! */
	public static String requestEarthQuakeData(Context context) {
		if (!isConnected(context)) {
			Log.e(tag, "Network not Available at this time.");
			return new String();
		}
		try {
			URL url = new URL(NetworkUtils.dataSrc);
			BufferedReader br 
				= new BufferedReader(
						new InputStreamReader(
								url.openStream()));
			StringBuilder sb = new StringBuilder();
			String temp = new String();
			do {
				sb.append(temp);
				temp = br.readLine();
			} while (temp!=null);
			Log.d(tag, "server feedback:"+sb.toString());
			return sb.toString();
		} catch (Exception e) {
			Log.e(tag, e.getMessage()+"");
			e.printStackTrace();
			// return null might cause crash to the upper
			return new String(); 
		}
	}// end of requestEarthQuakeData
	
	
	public static boolean isConnected(Context context) {
		if (context == null) {
			Log.e(tag, "context not available.");
			return false;
		}
		
		ConnectivityManager mConnectivityManager 
			= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo iface = mConnectivityManager.getActiveNetworkInfo();
		return (iface !=null && iface.isConnected());
	}
}// end of NetworkUtils class           





