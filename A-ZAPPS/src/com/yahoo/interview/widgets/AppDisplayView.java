package com.yahoo.interview.widgets;

import java.util.List;

import com.yahoo.interview.R;
import com.yahoo.interview.model.App;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class AppDisplayView extends ScrollView {

	private Context context;
	private List<App> mData = null;
	
	private LinearLayout mContentLayout;
	
	public AppDisplayView(Context con) {
		super(con);
		context = con;
		
		LayoutInflater li = 
				(LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.app_list, this, true);
		
		mContentLayout = (LinearLayout)this.findViewById(R.id.list_layout);
	}//end of constructor

	
	public void setDataSource(List<App> src) {
		mData = src;
	}
	
	public void refresh() {
		mContentLayout.removeAllViews();
		loadAll();
	}
	
	public void loadAll() {
		
	}
	
	public void loadAppsAtIndex(int index) {
		
	}
	
	public void removeAppAtIndex(int index) {
		
	}
	
}// end of AppDisplayView class     




