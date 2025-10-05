import java.util.Arrays;

public class JumpGameII {
	/**
	 * @param A: A list of lists of integers
	 * @return: An integer
	 */
	public int jump(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int[] dp = new int[A.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < A.length; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			int ceiling = i + A[i];
			if (ceiling >= A.length - 1) {
				return dp[i] + 1;
			}
			for (int j = i + 1; j <= ceiling; j++) {
				dp[j] = Math.min(dp[j], dp[i] + 1);
			}
		}
		return dp[A.length - 1];
	}
}
