
public class TwoStringsAreAnagrams {
	/**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
	public boolean anagram(String s, String t) {
		if (s == null || t == null) {
			return false;
		}

		s = s.trim();
		t = t.trim();

		if (s.length() != t.length()) {
			return false;
		}

		int[] amount = new int[256];
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			amount[c]++;
			c = t.charAt(i);
			amount[c]--;
		}

		for (int i : amount) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
}
