package com.thumbtack.interview.model;

public class Game {

	public String name; // the name displayed in a list
	public String id; // the id uniquely identify this instance in db
	public Tile[] tiles; // 1-dimen aray
	public String state; // win, lose or going, may change to an enum
	
	@Override
	public String toString() {
		// to a json string
		return "";
	}
}// end of game class
