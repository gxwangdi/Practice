import java.util.Set;

public class WordBreak {
	/**
	 * @param s: A string s
	 * @param dict: A dictionary of words dict
	 */
	private int maxWordLength(Set<String> dict) {
		int max = 0;
		if (dict == null || dict.size() == 0) {
			return max;
		}
		for (String s : dict) {
			max = Math.max(max, s.length());
		}
		return max;
	}

	// dp with max length.
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int maxLength = maxWordLength(dict); // speed up 1.
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			dp[i] = false;
			for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++) {
				if (!dp[i - lastWordLength]) { // speed up 2
					continue;
				}
				String word = s.substring(i - lastWordLength, i);
				if (dict.contains(word)) {
					dp[i] = true;
					break; // speed up 3.
				}
			}
		}
		return dp[s.length()];
	}

	/* // dp
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return true;
		}

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			dp[i] = false;
			for (int j = 0; j < i; j++) {
				if (dict.contains(s.substring(j, i))) {
					dp[i] |= dp[j];
				}
			}
		}
		return dp[s.length()];
	}*/

	/* // dfs
	public boolean wordBreak(String s, Set<String> dict) {
		// write your code here
		if (s == null || s.length() == 0) {
			return true;
		}
		boolean result = false;
		for (int i = 1; i <= s.length(); i++) {
			String sub = s.substring(0, i);
			if (!dict.contains(sub)) {
				continue;
			}
			result |= wordBreak(s.substring(i), dict);
		}
		return result;
	}// end of wordBreak
	*/
}
