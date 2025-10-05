public class LongestPalindromicSubstring {
	/**
	 * @param s input string
	 * @return the longest palindromic substring
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}

		String res = "";
		String temp;
		for (int i = 0; i < s.length() - 1; i++) {
			temp = getLongestPalindrome(s, i, i);
			if (temp.length() > res.length()) {
				res = temp;
			}
			temp = getLongestPalindrome(s, i, i + 1);
			if (temp.length() > res.length()) {
				res = temp;
			}
		}
		return res;
	}

	private String getLongestPalindrome(String s, int start, int end) {
		while (start >= 0 && end < s.length()
				&& s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		start++;
		end--;
		if (start <= end) {
			return s.substring(start, end + 1);
		}
		return "";
	}
}
