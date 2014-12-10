package com.yahoo.interview;

import java.util.List;

import com.yahoo.interview.model.App;
import com.yahoo.interview.model.Model;
import com.yahoo.interview.widgets.AppDisplayView;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private AppDisplayView mContentLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mContentLayout = (AppDisplayView)this.findViewById(R.id.contentLayout);
	}
	
	@Override
	protected void onResume () {
		super.onResume();
		new AsyncTask<Context, Void, Void>(){

			@Override
			protected Void doInBackground(Context... params) {
				Model model = new Model();
				List<App> apps = model.getAllApps(params[0], false);
				mContentLayout.setDataSource(apps);
				return null;
			}
			
			@Override
			protected void onPostExecute(Void param) {
				mContentLayout.loadAll();
			}
			
			
		}.execute(this);
	}

	
}// end of Activity class 




