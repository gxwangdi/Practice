package edu.gxwangdi.design.patterns;

/**
 * Template patterns occur all the time in OO software and are neither complex
 * nor obscure in intent. They are normal part of OO programming and you
 * shouldn't try to make them more abstract than they actually are. 
 * 
 * The first significant point is that your base class may only define some of the methods
 * it will be using, leaving the rest to be implemented in the derived classes.
 * 
 * The second major point is that there may be methods in the base class which
 * call a sequence of methods, some are implemented in the base class and some
 * are implemented in the derived class. This Template method defines a general
 * algorithm, although the details may not be worked out completely in the base
 * class. Template classes will frequently have some abstract methods that you
 * must override in the derived classes, and may also have some classes with a
 * simple "place-holder" implementation that you are free to override where
 * this is appropriate. If these place-holder classes are called from another
 * method in the base class, then we refer to these overridable methods are
 * "Hook" methods.
 */

abstract class Benchmark {
	/* operation below is expected to be finished in subclass */
	public abstract void benchmark();

	/* iterations for benchmark */
	public final long repeat(int count) {
		if (count <= 0) {
			return 0;
		} else {
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < count; i++) {
				benchmark();
			}
			long stopTime = System.currentTimeMillis();
			return stopTime - startTime;
		}
	}// end of repeat()
}// end of Benchmark class

public class Template extends Benchmark {

	/* define benchmark content */
	public void benchmark() {
		for (int i = 0; i < 100; i++) {
			System.out.println("i=" + i);
		}
	}// end of benchmark

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Benchmark operation = new Template();
		long duration = operation.repeat(10);
		System.out.println("The operation took " + duration + " milliseconds.");
	}

}// end of template class
