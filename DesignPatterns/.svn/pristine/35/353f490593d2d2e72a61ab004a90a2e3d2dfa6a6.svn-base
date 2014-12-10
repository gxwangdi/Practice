package com.eclipse.patterns;

/*
 * A Factory pattern is one that returns an instance of
one of several possible classes depending on the data provided to it. Usually
all of the classes it returns have a common parent class and common methods,
but each of them performs a task differently and is optimized for different
kinds of data.
 * 
 * You should consider using a Factory pattern when:
A class can`t anticipate which kind of class of objects it must create.
A class uses its subclasses to specify which objects it creates.
You want to localize the knowledge of which class gets created.

There are several similar variations on the factory pattern to recognize:
1. The base class is abstract and the pattern must return a complete working
class.
2. The base class contains default methods and is only subclassed for cases
where the default methods are insufficient.
3. Parameters are passed to the factory telling it which of several class types
to return. In this case the classes may share the same method names but
may do something quite different.
**/

interface iLogger
{
	public void log();
}

class FileLogger implements iLogger
{
	public void log()
	{
		System.out.println("FileLogger.");
	}
}

class DBLogger implements iLogger
{
	public void log()
	{
		System.out.println("DBLogger.");
	}
}


public class Factory {

	public static iLogger creator(int selector)
	{
		switch(selector)
		{
		case 1:return new FileLogger();
		case 2:return new DBLogger();
		default: return null;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		iLogger s;
		s=Factory.creator(1);
		if(s!=null) s.log();
		s=Factory.creator(2);
		if(s!=null) s.log();
	}
	
	
	
	

}////////end of Factory class


