package solution.ch01;

import java.util.Arrays;

public class Q1_4 {

	/*
	 * Write a method to decide if two strings are anagrams or not.
	 * */
	public static boolean isAnagram(String s1, String s2) {
		// Assuming s1 and s2 are not null.
		if (s1.length() != s2.length()) return false;
		
		int[] count = new int[256];
		Arrays.fill(count, 0);
		for (int i=0; i<s1.length(); i++) {
			int c1 = s1.charAt(i);
			int c2 = s2.charAt(i);
			count[c1]++;
			count[c2]--;
		}
		for (int i:count) {
			if (i!=0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] s1s = {"", "Hello world!", "nice"};
		String[] s2s = {" ", "Hell oworld!", "Nice"};
		for (int i=0; i<s1s.length; i++) {
			System.out.println(isAnagram(s1s[i], s2s[i]));
		}
	}// end of main
}
