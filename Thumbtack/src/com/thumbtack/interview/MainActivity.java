package com.thumbtack.interview;

import com.thumbtack.interview.fragments.GameFragment;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {

	private final String tag = "MainActivity";
	
	private GameFragment board;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// no need at this time.
		// board = (GameFragment)this.getFragmentManager().findFragmentById(R.id.board_fragment);
		
	}// end of onCraete

}// end of MainActivity class          



