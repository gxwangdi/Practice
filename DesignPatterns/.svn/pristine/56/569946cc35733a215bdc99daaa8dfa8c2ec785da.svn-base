package com.eclipse.patterns;

/**
 * 
 * The Adapter pattern is used to convert the programming interface of
 * one class into that of another. We use adapters whenever we want unrelated
 * classes to work together in a single program.
 * 
 * */

interface IRoundPeg{
	public void insertIntoHole(String msg);
}//end of IRoundPeg

interface ISquarePeg{
	public void insert(String str);
}//end of ISquarePeg

class SquarePeg implements ISquarePeg{
	public void insert(String str){
		System.out.println("SquarePeg insert():"+str);
	}
}//end of SquarePeg class

class RoundPeg implements IRoundPeg{
	public void insertIntoHole(String msg){
		System.out.println("RoundPeg insertIntoHole():"+msg);
	}
}//end of RoundPeg class

class PegAdapter implements IRoundPeg, ISquarePeg{
	private RoundPeg roundPeg;
	private SquarePeg squarePeg;
	
	public PegAdapter(RoundPeg peg){
		this.roundPeg = peg;
	}
	
	public PegAdapter(SquarePeg peg){
		this.squarePeg = peg;
	}
	
	@Override
	public void insert(String str){
		roundPeg.insertIntoHole(str);
	}

	@Override
	public void insertIntoHole(String msg) {
		// TODO Auto-generated method stub
		squarePeg.insert(msg);
	}
}//end of PegAdapter class

public class Adapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}//end of Adapter class
