
public class HouseRobber {
	/**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
	public long houseRobber(int[] A) {
		if (A == null || A.length == 0) {
			return 0l;
		}
		if (A.length == 1) {
			return A[0];
		}
		long[] dp = new long[A.length];
		dp[0] = A[0];
		dp[1] = Math.max(dp[0], A[1]);
		for (int i = 2; i < A.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i]);
		}
		return dp[A.length - 1];
	}
}
