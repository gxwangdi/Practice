package com.eclipse.patterns;

/*
 * There are any number of cases in programming where you need to make sure that 
 * there can be one and only one instance of a class.
 * 
 * 1. It can be difficult to subclass a Singleton, since this can only work if the 
 * base Singleton class has not yet been instantiated.
 * 2. You can easily change a Singleton to allow a small number of instances 
 * where this is allowable and meaningful.
 * 
*/

public class Singleton {

	private static Singleton instance;
	private String content;
	
	private Singleton(String s)
	{
		content=s;
	}////private constructor
	
	public synchronized static Singleton getInstance(String s)
	{
		if (instance==null)
			instance= new Singleton(s);
		return instance;
	}////insure only one instance
	
	public String getContent()
	{
		return content;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton s=Singleton.getInstance("instance 1");
		System.out.println(s.getContent());
		
		Singleton ss=Singleton.getInstance("instance 2");
		System.out.println(ss.getContent());
	}

}//////end of Singleton class


