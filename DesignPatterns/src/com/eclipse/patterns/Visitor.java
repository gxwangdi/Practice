package com.eclipse.patterns;

import java.util.Collection;
import java.util.Iterator;

/*
 * You should consider using a Visitor pattern when you want to
perform an operation on the data contained in a number of objects that have
different interfaces. Visitors are also valuable if you have to perform a
number of unrelated operations on these classes.

The Visitor pattern is useful when you want to encapsulate fetching
data from a number of instances of several classes. Design Patterns suggests
that the Visitor can provide additional functionality to a class without
changing it. We prefer to say that a Visitor can add functionality to a
collection of classes and encapsulate the methods it uses.
The Visitor is not magic, however, and cannot obtain private data
from classes: it is limited to the data available from public methods. This
might force you to provide public methods that you would otherwise not have
provided. However, it can obtain data from a disparate collection of unrelated
classes and utilize it to present the results of a global calculation to the user
program.       

It is easy to add new operations to a program using Visitors, since the
Visitor contains the code instead of each of the individual classes. Further,
Visitors can gather related operations into a single class rather than forcing
you to change or derive classes to add these operations. This can make the
program simpler to write and maintain.

Visitors are less helpful during a program`s growth stage, since each
time you add new classes which must be visited, you have to add an abstract
visit operation to the abstract Visitor class, and you must add an 
implementation for that class to each concrete Visitor you have written.
Visitors can be powerful additions when the program reaches the point where
many new classes are unlikely.

Visitors can be used very effectively in Composite systems and the
boss-employee system we just illustrated could well be a Composite like the
one we used in the Composite chapter.
 * */

interface IVisitor
{
	public void visitCollection(Collection collection);
	public void visitString(String str);
	public void visitFloat(Float f);
}

interface Visitable
{
	public void accept(IVisitor visitor);
}

class ConcreteElement implements Visitable{
	private String value;
	public ConcreteElement(String string){
		value = string;
	}
	//define accept
	public void accept(IVisitor visitor){
		visitor.visitString(this.toString());
	}
}//end of ConcreteElement class

class ConcreteVisitor implements IVisitor{

	@Override
	public void visitCollection(Collection collection) {
		Iterator iterator = collection.iterator();
		while (iterator.hasNext())
		{
			Object o = iterator.next();
			if(o instanceof Visitable)
				((Visitable)o).accept(this);
		}
	}//end of visitCollection()

	@Override
	public void visitFloat(Float f) {
		System.out.println(f.toString()+"f");
	}

	@Override
	public void visitString(String str) {
		System.out.println("'"+str+"'");
	}
}//end of ConcreteVisitor class


public class Visitor {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}//end of visitor class




