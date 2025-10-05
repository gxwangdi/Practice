
public class BackpackVI {
	/**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
	public int backPackVI(int[] nums, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int num : nums) {
				if (num <= i)
					dp[i] += dp[i - num];
			}
		}
		return dp[target];
	}
}
