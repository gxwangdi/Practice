package edu.gxwangdi.java8.features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/*
 * Whenever we need to traverse through a Collection, we need to create an 
 * Iterator whose whole purpose is to iterate over and then we have business 
 * logic in a loop for each of the elements in the Collection. We might get 
 * ConcurrentModificationException if iterator is not used properly.
 * 
 * Java 8 has introduced forEach method in java.lang.Iterable interface so 
 * that while writing code we focus on business logic only. forEach method 
 * takes java.util.function.Consumer object as argument, so it helps in having 
 * our business logic at a separate location that we can reuse.
 * */

public class IterableInterface {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			myList.add(i);
		}

		Iterator<Integer> it = myList.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println("Iterator Values:" + i);
		}

		myList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::" + t);
			}
		});

		myList.forEach((t) -> {
			System.out.println("forEach lambda expression value::" + t);
		});

		MyConsumer action = new MyConsumer();
		myList.forEach(action);
	}

	// Customized consumer implementation.
	private static class MyConsumer implements Consumer<Integer> {
		public void accept(Integer t) {
			System.out.println("My consumer impl Value::" + t);
		}
	}
}
