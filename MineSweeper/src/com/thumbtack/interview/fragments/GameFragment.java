package com.thumbtack.interview.fragments;

import java.util.Random;

import com.thumbtack.interview.R;
import com.thumbtack.interview.model.Tile;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class GameFragment 
extends Fragment 
implements OnClickListener{

	private Tile[][] tiles = null;
	private TableLayout mMineField;
	
	private int mRows = 8;
	private int mColumns = 8;
	private int mMines = 10;
	
	private int mBlockSize = 30;
	private int mBlockPadding = 5;
	
	private View mValidateBtn;
	private View mCheatBtn;
	private View mNewBtn;
	private View mSaveBtn;
	private View mLoadBtn;
	private View mSettingsBtn;
	
	private boolean isCheatMode = false;
	private boolean isGameGoing = true;
	
	public GameFragment() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_game, container, false);
		
		mMineField = (TableLayout)rootView.findViewById(R.id.mine_field);
		setupBlocks();   
//		resume();
		plantMines();
		setupMineFieldUI(); 
		
		mValidateBtn = rootView.findViewById(R.id.validate_btn);
		mValidateBtn.setOnClickListener(this);
		mCheatBtn = rootView.findViewById(R.id.cheat_btn);
		mCheatBtn.setOnClickListener(this);
		
		mNewBtn = rootView.findViewById(R.id.new_btn);
		mNewBtn.setOnClickListener(this);
		mSaveBtn = rootView.findViewById(R.id.save_btn);
		mSaveBtn.setOnClickListener(this);
		mLoadBtn = rootView.findViewById(R.id.load_btn);
		mLoadBtn.setOnClickListener(this);
		mSettingsBtn = rootView.findViewById(R.id.settings_btn);
		mSettingsBtn.setOnClickListener(this);         
		     
		return rootView;
	}
	
	private void setupBlocks() {
		if (tiles == null) {
			tiles = new Tile[mRows][mColumns];
			TableRow.LayoutParams trParams = 
					new TableRow.LayoutParams(
							mBlockSize+2*mBlockPadding
							, mBlockSize+2*mBlockPadding);
			trParams.setMargins(mBlockPadding, mBlockPadding, mBlockPadding, mBlockPadding);
			for (int i=0; i<mRows; i++) 
				for (int j=0; j<mColumns; j++) {
					tiles[i][j] = new Tile(this.getActivity());
					// blocks[i][j].setText(""+i+j);
					tiles[i][j].setLayoutParams(trParams);
					tiles[i][j].setPadding(
							mBlockPadding
							, mBlockPadding
							, mBlockPadding
							, mBlockPadding);
					final int row = i;
					final int column = j;
					tiles[i][j].setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View v) {
							openTileAt(row, column);
						}
						
					});
				}
		}
		// setup mines
	}// end of setupBlocks        
	
	
	private void openTileAt(int r, int c) {
		tiles[r][c].open();
		if (tiles[r][c].isMine()) {
			gameEndUp(false);
			return;
		}
		
		if (tiles[r][c].getAdjacentMineAmount() == 0) {
			if (r>0 && tiles[r-1][c].isCovered())
				openTileAt(r-1, c);
			
			if (c>0 && tiles[r][c-1].isCovered())
				openTileAt(r, c-1);
			
			if (r+1<mRows && tiles[r+1][c].isCovered())
				openTileAt(r+1, c);
			
			if (c+1<mColumns && tiles[r][c+1].isCovered())
				openTileAt(r, c+1);
		}
	}
	
	
	// setup the pre-condition of a game
	private void resume() {
		for (int i=0; i<mRows; i++)
			for (int j=0; j<mColumns; j++)
				tiles[i][j].resume();
		
		plantMines();
		
		isGameGoing = true;
		isCheatMode = false;
	}
	
	
	private void plantMines() {
		Random rand = new Random();
		int mines = mMines;
		while (mines >0) {
			int row = rand.nextInt(mRows);
			int column = rand.nextInt(mColumns);
			if (tiles[row][column].isMine())
				continue;
			
			tiles[row][column].plantMine();
			mines--;
			if (row>0) // top
				tiles[row-1][column].increaseAdjacentMineAmount();
			
			if (column>0) // left
				tiles[row][column-1].increaseAdjacentMineAmount();
			
			if (row<mRows-1) // down
				tiles[row+1][column].increaseAdjacentMineAmount();
			
			if (column<mColumns-1) // right
				tiles[row][column+1].increaseAdjacentMineAmount(); 
			
			// Actually triangle counts
			if (row>0 && column>0)
				tiles[row-1][column-1].increaseAdjacentMineAmount();
			
			if (row>0 && column<mColumns-1)
				tiles[row-1][column+1].increaseAdjacentMineAmount();
			
			if (row<mRows-1 && column>0)
				tiles[row+1][column-1].increaseAdjacentMineAmount();
			
			if (row<mRows-1 && column<mColumns-1)
				tiles[row+1][column+1].increaseAdjacentMineAmount();
			
		}
	}// end of plantMines
	
	
	private void setupMineFieldUI() {
		TableLayout.LayoutParams tlParams = 
				new TableLayout.LayoutParams(
						(mBlockSize+2*mBlockPadding)*mColumns
						, mBlockSize+2*mBlockPadding);
		
//		ViewGroup.LayoutParams vgParams = 
//				new ViewGroup.LayoutParams(
//						ViewGroup.LayoutParams.WRAP_CONTENT
//						, ViewGroup.LayoutParams.WRAP_CONTENT);
		
//		LayoutParams params = new LayoutParams(
//				LayoutParams.MATCH_PARENT
//				, LayoutParams.WRAP_CONTENT);
//		TableRow.LayoutParams trParams = 
//				new TableRow.LayoutParams(80,80);
//		mMineField.removeAllViews();
		for (int i=0; i<mRows; i++) {
			TableRow row = new TableRow(this.getActivity());
			row.setLayoutParams(tlParams);
			// row.setLayoutParams(tlParams);
			for (int j=0; j<mColumns; j++) {
				row.addView(tiles[i][j]);
			}
			mMineField.addView(row, tlParams);     
		}
	}

	
	private boolean isGameWin() {
		for (int i=0; i<mRows; i++) {
			for (int j=0; j<mColumns; j++) {
				if (tiles[i][j].isCovered() && !tiles[i][j].isMine())
					return false;
			}
		}
		return true;
	}
	
	
	private void gameEndUp(boolean isWin) {
		Toast.makeText(
				this.getActivity()
				, isWin?R.string.congratulations_you_win:R.string.you_lose
						, Toast.LENGTH_SHORT).show();
		
		isGameGoing = false;
		// freeze the board
		for (int i=0; i<mRows; i++) {
			for (int j=0; j<mColumns; j++) {
				tiles[i][j].setEnabled(false);
			}
		}
	}// end of gameEndUp           
	
	@Override
	public void onClick(View v) {
		if (v == mValidateBtn) {
			gameEndUp(isGameWin());
			return;
		}
		
		if (v == mCheatBtn) {
			isCheatMode = !isCheatMode;
			for (int i=0; i<mRows; i++) {
				for (int j=0; j<mColumns; j++) {
					tiles[i][j].setCheatMode(isCheatMode);
				}
			}
			return;
		}
		
		if (v == mNewBtn) {
			setupBlocks(); // just in case
			resume();
			return;
		}
		
		if (v == mSaveBtn) {
			Toast.makeText(
					this.getActivity()
					, R.string.feature_not_implemented
					, Toast.LENGTH_SHORT).show();
			return;
		}
		
		if (v == mLoadBtn) {
			Toast.makeText(
					this.getActivity()
					, R.string.feature_not_implemented
					, Toast.LENGTH_SHORT).show();
			return;
		}
		
		if (v == mSettingsBtn) {
			Toast.makeText(
					this.getActivity()
					, R.string.feature_not_implemented
					, Toast.LENGTH_SHORT).show();
			return;
		}
		
	}
}// end of GameFragment class        




