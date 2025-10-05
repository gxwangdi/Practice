public class InterleavingString {
	/**
	 * Determine whether s3 is formed by interleaving of s1 and s2.
	 * 
	 * @param s1
	 *            , s2, s3: As description.
	 * @return: true or false.
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null
				|| s3.length() != s1.length() + s2.length()) {
			return false;
		}

		int m = s1.length();
		int n = s2.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i < m + 1; i++) {
			dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && dp[i - 1][0];
		}
		for (int j = 1; j < n + 1; j++) {
			dp[0][j] = (s2.charAt(j - 1) == s3.charAt(j - 1)) && dp[0][j - 1];
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j
						- 1))
						|| (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j
								- 1));
			}
		}

		return dp[m][n];
	}
}
