package com.yahoo.interview.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.PackageInfo;

public class Model implements IFetchable
{

	@Override
	public List<App> getAllApps(Context con,boolean isSysIncluded) {
		
		return getApps(con, ALL_INDEX, isSysIncluded);
	}

	@Override
	public List<App> getAppsAtIndex(Context con, int index, boolean isSysIncluded) {
		
		return getApps(con, index, isSysIncluded);
	}

	
	private List<App> getApps(Context con, int index, boolean isSysIncluded) {
		List<App> res = new ArrayList<App>();
		List<PackageInfo> packs = 
				con.getPackageManager()
				.getInstalledPackages(0);
		for (int i=0; i<packs.size(); i++) {
			PackageInfo p = packs.get(i);
			if ((!isSysIncluded) && (p.versionName == null)) {
				continue;
			}
			
			App app = new App();
			app.appName = 
					p.applicationInfo.loadLabel(
							con.getPackageManager()).toString();
			app.pName = p.packageName;
			app.icon = p.applicationInfo.loadIcon(con.getPackageManager());
			if (index == ALL_INDEX) {
				res.add(app);
			} else {
				char c = (char)(index+'a');
				if (app.appName.startsWith(c+""))
					res.add(app);
			}
		}
		return res;
	}
	
}// end of Model class      




