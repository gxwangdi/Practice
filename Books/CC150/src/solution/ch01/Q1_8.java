package solution.ch01;

public class Q1_8 {

	/*
	 * Assume you have a method isSubstring which checks if one word is a 
	 * substring of another Given two strings, s1 and s2, write code to check 
	 * if s2 is a rotation of s1 using only one call to isSubstring 
	 * (i e , “waterbottle” is a rotation of “erbottlewat”)
	 * */
	private static boolean isSubstring(String haystack, String needle) {
		if (haystack == null) return false;
		return haystack.indexOf(needle)!=-1;
	}
	
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		s1 = s1 + s1;
		return isSubstring(s1, s2);
	}
	
	public static void main(String[] args) {
		String[] haystacks = {"sthank folks!", "", "hello", "world!"};
		String[] needles = {"thanks", "", "llohe", "!World"};
		for (int i=0; i<needles.length; i++) {
			System.out.println(isRotation(haystacks[i], needles[i]));
		}
	}// end of main     
}
