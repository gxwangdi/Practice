package edu.gxwangdi.design.patterns;

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
public class SingletonPattern {

	private static SingletonPattern instance;
	private String content;

	private SingletonPattern(String s) {
		content = s;
	}// private constructor

	public synchronized static SingletonPattern getInstance(String s) {
		if (instance == null) {
			instance = new SingletonPattern(s);
		}
		return instance;
	}// insure only one instance

	public String getContent() {
		return content;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingletonPattern s = SingletonPattern.getInstance("instance 1");
		System.out.println(s.getContent());

		SingletonPattern ss = SingletonPattern.getInstance("instance 2");
		System.out.println(ss.getContent());
	}

}// end of Singleton class
