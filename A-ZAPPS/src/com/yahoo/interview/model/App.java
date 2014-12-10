package com.yahoo.interview.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class App {

	public String appName;
	public String pName;
	public Drawable icon;
	public int fre;
	
	
	public void start(Context c) {
		Intent intent = 
				c.getPackageManager()
				.getLaunchIntentForPackage(pName);
		c.startActivity(intent);
	}
}// end of App class
