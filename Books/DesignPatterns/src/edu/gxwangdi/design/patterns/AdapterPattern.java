package edu.gxwangdi.design.patterns;

/*
 * The Adapter pattern is used to convert the programming interface of
 * one class into that of another. We use adapters whenever we want unrelated
 * classes to work together in a single program. 
 * */

interface IRoundPeg {
	public void insertIntoHole(String msg);
}// end of IRoundPeg

interface ISquarePeg {
	public void insert(String str);
}// end of ISquarePeg

class SquarePeg implements ISquarePeg {
	public void insert(String str) {
		System.out.println("SquarePeg insert():" + str);
	}
}// end of SquarePeg class

class RoundPeg implements IRoundPeg {
	public void insertIntoHole(String msg) {
		System.out.println("RoundPeg insertIntoHole():" + msg);
	}
}// end of RoundPeg class

class PegAdapter implements IRoundPeg, ISquarePeg {
	private RoundPeg roundPeg;
	private SquarePeg squarePeg;

	public PegAdapter(RoundPeg peg) {
		this.roundPeg = peg;
	}

	public PegAdapter(SquarePeg peg) {
		this.squarePeg = peg;
	}

	@Override
	public void insert(String str) {
		if (roundPeg == null) {
			return;
		}
		roundPeg.insertIntoHole(str);
	}

	@Override
	public void insertIntoHole(String msg) {
		if (squarePeg == null) {
			return;
		}
		squarePeg.insert(msg);
	}
}// end of PegAdapter class

public class AdapterPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PegAdapter adapter = new PegAdapter(new SquarePeg());
		adapter.insert("1");
		adapter.insertIntoHole("2");
		
		adapter = new PegAdapter(new RoundPeg());
		adapter.insert("1");
		adapter.insertIntoHole("2");
	}

}// end of Adapter class
