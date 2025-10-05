
public class ValidPalindrome {
	/**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		s = s.toLowerCase();
		s = s.replaceAll("[^a-z0-9]", "");
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
