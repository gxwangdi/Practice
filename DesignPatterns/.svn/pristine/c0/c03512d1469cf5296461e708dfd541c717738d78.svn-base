package com.eclipse.patterns;

import java.util.Hashtable;

/*
 * 
 * */

class ExtrinsicState
{
	// the extrinsic state of flyweight
}

class IntrinsicState
{
	// the intrinsic State of flyweight
}

interface IFlyweight
{
	public void operation(ExtrinsicState state);
}//end of Flyweight interface

class ConcreteFlyweight implements IFlyweight
{
	private IntrinsicState state;
	
	public void operation(ExtrinsicState state)
	{
		System.out.println("operation detail implementation.");
	}//end of operation
}//end of concreteFlyweight class

class UnsharedConcreteFlyweight implements IFlyweight
{
	public void operation(ExtrinsicState state){}
}//end of UnsharedConcreteFlyweight class

class FlyweightFactory
{
	//Flyweight pool
	private Hashtable flyweights = new Hashtable();
	
	public IFlyweight getFlyweight(Object key)
	{
		IFlyweight flyweight = (IFlyweight) flyweights.get(key);
		if(flyweight == null)
		{
			//generate new ConcreteFlyweight
			flyweight = new ConcreteFlyweight();
			flyweights.put(key, flyweight);
		}
		return flyweight;
		
	}
}

public class Flyweight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		IFlyweight fly1 = factory.getFlyweight("Fred");
		IFlyweight fly2 = factory.getFlyweight("Wilma");
	}
}
