package solution.ch01;

import java.util.HashSet;
import java.util.Set;

public class Q1_1 {

	/*
	 * Implement an algorithm to determine if a string has all unique 
	 * characters What if you can not use additional data structures?
	 * */
	/*
	private static boolean isAllUnique(String s) {
		if (s == null || s.length()<2) 
			return true;
		
		Set<Character> set = new HashSet<>();
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) return false;
			set.add(c);
		}
		return true;
	}*/
	
	private static boolean isAllUnique(String s) {
		if (s == null || s.length()<2)
			return true;
		
		boolean[] chars = new boolean[256];
		for (int i=0; i<s.length(); i++) {
			int c = s.charAt(i);
			if (chars[c]) return false;
			chars[c] = true;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		String[] tests = {null, "Hello World!", "ABDFGHJKLpoieuytr"};
		for (String s:tests) {
			System.out.println(s + ":" + isAllUnique(s));
		}
	}// end of main   
}
