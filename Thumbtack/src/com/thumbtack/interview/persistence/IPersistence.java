package com.thumbtack.interview.persistence;

import java.util.List;

import com.thumbtack.interview.model.Game;


public interface IPersistence {

	// update record if there is record
	// insert new if there is no.
	public void saveGame(Game game);
	
	public List<Game> loadAll();
	
	public Game loadGame(String id); 
	
	public void deleteGame(String id);
	
	// delete all
	public void clear();
	
	// return null if it does not exist.
	// ';' separated if there are multiple IDs
	public String isExist(String Name);
}// end of IPersistence     






