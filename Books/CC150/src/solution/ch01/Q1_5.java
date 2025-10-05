package solution.ch01;

public class Q1_5 {

	
	/*
	 * Write a method to replace all spaces in a string with ‘%20’.
	 * */
	public static String replaceSpace(String s) {
		if (s == null) return null;
		return s.replaceAll("[ ]", "%20");
	}
	
	public static void main(String[] args) {
		String[] tests = {"", "    ", "Hello world!"};
		for (String s:tests) {
			System.out.println(s + ":" + replaceSpace(s));
		}
	}// end of main      
}



