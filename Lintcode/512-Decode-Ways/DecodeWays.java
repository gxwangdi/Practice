public class DecodeWays {
	/**
	 * @param s
	 *            a string, encoded message
	 * @return an integer, the number of ways decoding
	 */
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) != '0') {// PAY Attention to the case where '0'
											// appears in the middle.
				dp[i] = dp[i - 1];
			}

			int code = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
			if (code >= 10 && code <= 26) {
				dp[i] += dp[i - 2]; // PAY ATTention to how dp[i] reflect all
									// possibilities!
			}
		}
		return dp[s.length()];
	}
}
