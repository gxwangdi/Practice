package com.eclipse.patterns;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * The Decorator pattern provides us with a way to modify the behavior
of individual objects without having to create a new derived class.
 * 
 * The Decorator pattern provides a more flexible way to add
responsibilities to a class than by using inheritance, since it can add these
responsibilities to selected instances of the class. It also allows you to
customize a class without creating subclasses high in the inheritance
hierarchy. 

Design Patterns points out two disadvantages of the Decorator
pattern One is that a Decorator and its enclosed component are not identical.
Thus tests for object type will fail. The second is that Decorators can lead to a
system with ¡°lots of little objects¡± that all look alike to the programmer trying
to maintain the code. This can be a maintenance headache.
 * 
 * */

interface Work{
	public void insert();
}//end of Work

class DSquarePeg implements Work{
	public void insert(){
		System.out.println("insert square peg.");
	}
}//end of class SquarePeg

public class Decorator implements Work {

	private Work work;
	
	private ArrayList others = new ArrayList();
	
	public Decorator(Work work){
		this.work = work;
		
		others.add("dig~");
		
		others.add("add wood~");
	}//end of constructor
	
	public void insert(){
		newMethod();
	}//end of insert()
	
	/* we can add additional operations before insert()
	 * in this method.
	 * The sequence could be specified according to the real situation.*/
	public void newMethod()
	{
		otherMethod();
		work.insert();
	}//end of newMethod()
	
	public void otherMethod()
	{
		ListIterator listIterator=others.listIterator();
		while (listIterator.hasNext())
		{
			System.out.println(((String)(listIterator.next()))
					+"is running.");
		}
	}//end of otherMethod()
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Work squarePeg = new DSquarePeg();
		Work decorator = new Decorator(squarePeg);
		decorator.insert();
	}

}//end of Decorator class 




