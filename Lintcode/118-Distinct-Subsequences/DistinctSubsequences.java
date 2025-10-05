public class DistinctSubsequences {
	/**
	 * @param S
	 *            , T: Two string.
	 * @return: Count the number of distinct subsequences
	 */
	public int numDistinct(String S, String T) {
		if (S == null || T == null) {
			return 0;
		}
		int m = S.length();
		int n = T.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				// At least it has all existing solutions
				dp[i][j] = dp[i - 1][j];
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					// it adds all the possibilities for the case we take T[j-1]
					// to match S[i-1].
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}

		return dp[m][n];
	}
}
