public class LongestCommonSubstring {
	/**
	 * @param A, B: Two string.
	 * @return: the length of the longest common substring.
	 */
	public int longestCommonSubstring(String A, String B) {
		int max = 0;
		if (A == null || A.length() == 0 || B == null || B.length() == 0) {
			return max;
		}
		int m = A.length();
		int n = B.length();
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char ci = A.charAt(i);
				char cj = B.charAt(j);
				if (ci != cj) {
					dp[i][j] = 0;
				} else {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}// end of longestCommonSubstring
}
