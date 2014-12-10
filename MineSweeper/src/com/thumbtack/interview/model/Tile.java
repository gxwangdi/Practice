package com.thumbtack.interview.model;


import com.thumbtack.interview.R;

import android.content.Context;
import android.widget.Button;

public class Tile extends Button {

	private int mAdjMineAmount;
	private boolean isCovered;
	private boolean isMined;
	
	public Tile(Context context) {
		super(context);
		mAdjMineAmount = 0;
		isCovered = true;
		isMined = false;
		this.setEnabled(true);
		this.setBackgroundResource(R.drawable.bg_cheat);
	}
	
	// set to default state
	public void resume() {
		mAdjMineAmount = 0;
		isCovered = true;
		isMined = false;
		this.setEnabled(true);
		this.setBackgroundResource(R.drawable.bg_cheat);
		this.setText("");
	}
	
	public int getAdjacentMineAmount() {
		return mAdjMineAmount;
	}
	
	public void increaseAdjacentMineAmount() {
		mAdjMineAmount++;
	}
	
	public boolean isMine() {
		return isMined;
	}
	
	public void plantMine() {
		isMined = true;
	}
	
	public boolean isCovered() {
		return isCovered;
	}
	
	public void open() {
		isCovered = false;
		this.setEnabled(false);
		if (isMined) {
			this.setText("M");
		} else {
			this.setText(""+ mAdjMineAmount);
		}
	}
	
	
	public void setCheatMode(boolean cheat) {
		if (!cheat) {
			this.setBackgroundResource(R.drawable.bg_cheat);
		} else if (isMined){
			this.setBackgroundResource(R.drawable.bg_normal);
		}
	}

}// end of Tile class           




