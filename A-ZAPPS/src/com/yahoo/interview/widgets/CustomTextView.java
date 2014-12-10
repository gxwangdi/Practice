package com.yahoo.interview.widgets;

import com.yahoo.interview.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomTextView extends RelativeLayout {

	private Context context;
	private boolean mIsApp;
	
	private TextView mText;
	private TextView mTitle;
	private ImageView mIcon;
	
	public CustomTextView(Context con, boolean isApp) {
		super(con);
		context = con;
		mIsApp = isApp;
		LayoutInflater li = 
				(LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.app_item, this, true);
		mText = this.findViewById(R.id.text);
		mTitle = this.findViewById(R.id.title);
		mIcon = this.findViewById(R.id.icon);
		
		if (isApp) {
			mText.setVisibility(View.GONE);
			mTitle.setVisibility(View.VISIBLE);
			mIcon.setVisibility(View.VISIBLE);
		} else {
			mText.setVisibility(View.VISIBLE);
			mTitle.setVisibility(View.GONE);
			mIcon.setVisibility(View.GONE);
		}
	}// end of constructor
	
	public void setText(final CharSequence text) {
		mText.setText(text);
	}
	
	public void setImage(final Drawable d) {
		mIcon.setImageDrawable(d);
	}
	
	public void setTitle(final CharSequence title) {
		mTitle.setText(title);
	}

}// end of CustomTextView    




