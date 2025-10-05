package edu.gxwangdi.design.patterns;

import java.util.ArrayList;
import java.util.List;

/*
 * The Decorator pattern provides us with a way to modify the behavior of 
 * individual objects without having to create a new derived class.
 * 
 * The Decorator pattern provides a more flexible way to add responsibilities 
 * to a class than by using inheritance, since it can add these 
 * responsibilities to selected instances of the class. It also allows you to 
 * customize a class without creating subclasses high in the inheritance 
 * hierarchy. 
 * 
 * Design Patterns points out two disadvantages of the Decorator pattern: 
 * One is that a Decorator and its enclosed component are not identical. Thus 
 * tests for object type will fail. The second is that Decorators can lead to 
 * a system with lots of little objects that all look alike to the programmer 
 * trying to maintain the code. This can be a maintenance headache.
 * 
 * */

interface Work {
	void insert();
}// end of Work

class DSquarePeg implements Work {
	public void insert() {
		System.out.println("insert square peg.");
	}
}// end of class SquarePeg

public class DecoratorPattern implements Work {

	private Work work;
	private List<String> others = new ArrayList<>();

	public DecoratorPattern(Work work) {
		this.work = work;

		others.add("dig~");
		others.add("add wood~");
	}// end of constructor

	/*
	 * We can add additional operations before insert() in this method. The sequence
	 * could be specified according to the real situation.
	 */
	public void insert() {
		// In this way we can enjoy work`s deliverable without inheritance.
		otherMethod();
		work.insert();
	}// end of insert()

	public void otherMethod() {
		for (String s : others) {
			System.out.println(s + " is running.");
		}
	}// end of otherMethod()

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Work squarePeg = new DSquarePeg();
		Work decorator = new DecoratorPattern(squarePeg);
		decorator.insert();
	}

}// end of Decorator class
