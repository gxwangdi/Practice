public class MinimumSizeSubarraySum {
	/**
	 * @param nums
	 *            : an array of integers
	 * @param s
	 *            : an integer
	 * @return: an integer representing the minimum size of subarray
	 */
	public int minimumSize(int[] nums, int s) {
		if (s < 0 || nums == null || nums.length == 0) {
			return -1;
		}

		int min = Integer.MAX_VALUE;
		int slow = 0;
		int fast = 0;
		int sum = nums[fast];
		while (fast < nums.length) {
			if (nums[fast] >= s) {
				return 1;
			}
			if (sum < s) {
				fast++;
				if (fast < nums.length) {
					sum += nums[fast];
				}
				continue;
			}

			min = Math.min(min, fast - slow + 1);
			sum -= nums[slow];
			slow++;
		}
		if (sum < s && min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;
	}
}
