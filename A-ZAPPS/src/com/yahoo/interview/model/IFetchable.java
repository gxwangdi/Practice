package com.yahoo.interview.model;

import java.util.List;

import android.content.Context;

public interface IFetchable {

	public final int ALL_INDEX = -1;
	
	public List<App> getAllApps(Context c, boolean isSysIncluded);
	
	public List<App> getAppsAtIndex(Context C, int index, boolean isSysIncluded);
}// end of IFetchable




