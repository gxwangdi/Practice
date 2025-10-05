package edu.gxwangdi.java8.features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 * A new java.util.stream has been added in Java 8 to perform filter/map/reduce 
 * like operations with the collection. Stream API will allow sequential as well 
 * as parallel execution.
 * 
 * */
public class StreamAPI {

	public static void main(String[] args) {

//		List<byte[]> list = new ArrayList<>();
//		for (byte[] b : list) {
//			System.out.println("empty collection works fine.");
//		}
//		list.add(null);
//		for (byte[] b : list) {
//			System.out.println("null element works fine.");
//		}
//		list = null;
//		for (byte[] b : list) {
//			System.out.println("null list works fine.");
//		}
		
		
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			myList.add(i);
		}

		// Sequential Stream
		Stream<Integer> sequentialStream = myList.stream();

		// Parallel Stream
		Stream<Integer> parallelStream = myList.parallelStream();

		// Using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p >= 90);

		// Using lambda in forEach.
		highNums.forEach(p -> System.out.println("High Nums parallel=" + p));

		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);

		highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));

		// TODO: Add more samples for java8 Stream APIs.
		// https://www.journaldev.com/2774/java-8-stream
	}
}
