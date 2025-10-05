public class HouseRobberII {
	/**
	 * @param nums
	 *            : An array of non-negative integers. return: The maximum
	 *            amount of money you can rob tonight
	 */
	public int houseRobber2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int max1 = robHelper(nums, 0, nums.length - 2);
		int max2 = robHelper(nums, 1, nums.length - 1);

		return Math.max(max1, max2);
	}

	private int robHelper(int[] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}

		int[] dp = new int[nums.length];
		dp[start] = nums[start];
		dp[start + 1] = Math.max(dp[start], nums[start + 1]);
		for (int i = start + 2; i <= end; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[end];
	}
}
