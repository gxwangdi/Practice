package com.yahoo.interview.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class FakeModel implements IFetchable
{

	@Override
	public List<App> getAllApps(Context con) {
		List<App> res = new ArrayList<App>();
		for (char c='a'; c<='z'; c++) {
			App app = new App();
			app.appName = c+"";
			app.pName = c+" package";
			app.icon = con.getResources().getDrawable(R.drawable.ic_launcher);
			res.add(app);
		}
		
		return res;
	}

	@Override
	public List<App> getAppsAtIndex(Context con, int index) {
		List<App> res = new ArrayList<App>();
		App app = new App();
		char c = (char)(index+'a');
		app.appName = c + "";
		app.pName = c + " package";
		app.icon = con.getResources().getDrawable(R.drawable.ic_launcher);
		res.add(app);
		return res;
	}

}
