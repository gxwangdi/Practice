
public class PalindromePartitionII {
	/**
	 * @param s a string
	 * @return an integer
	 */
	public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		boolean[][] IP = getIsPalindrome(s);
		int[] dp = new int[s.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = i;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (!IP[j][i - 1]) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[j] + 1);
			}
		}
		return dp[s.length()] - 1;
	}

	private boolean[][] getIsPalindrome(String s) {
		boolean[][] IP = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			IP[i][i] = true;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			IP[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
		}
		for (int len = 2; len < s.length(); len++) {
			// Pay attention how it deals with i...j
			for (int start = 0; start + len < s.length(); start++) {
				IP[start][start + len] = IP[start + 1][start + len - 1] && (s.charAt(start) == s.charAt(start + len));
			}
		}
		return IP;
	}
}
