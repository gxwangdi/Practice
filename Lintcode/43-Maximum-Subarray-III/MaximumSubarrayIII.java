
public class MaximumSubarrayIII {
	/**
	 * @param nums: A list of integers
	 * @param k: An integer denote to find k non-overlapping subarrays
	 * @return: An integer denote the sum of max k non-overlapping subarrays
	 */
	public int maxSubArray(int[] nums, int k) {
		int len = nums.length;
		int[][] f = new int[k + 1][len];
		for (int i = 1; i < k + 1; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += nums[j];
			}
			f[i][i - 1] = sum;
		}
		for (int i = 1; i < len; i++) {
			f[1][i] = Math.max(f[1][i - 1] + nums[i], nums[i]);
		}

		for (int i = 2; i < k + 1; i++) {
			for (int n = i; n < len; n++) {
				int curMax = f[i][n - 1] + nums[n];
				for (int j = i - 2; j < n; j++) {
					if ((f[i - 1][j] + nums[n]) > curMax) {
						curMax = f[i - 1][j] + nums[n];
					}
				}
				f[i][n] = curMax;
			}
		}

		int res = Integer.MIN_VALUE;
		for (int i = k - 1; i < len; i++) {
			if (f[k][i] > res) {
				res = f[k][i];
			}
		}
		return res;
	}
	/*
	public int maxSubArray(int[] nums, int k) {
		if (nums == null || nums.length < k) {
			return 0;
		}
		int len = nums.length;

		int[][] globalMax = new int[k + 1][len + 1];
		int[][] localMax = new int[k + 1][len + 1];

		for (int i = 1; i <= k; i++) {
			localMax[i][i - 1] = Integer.MIN_VALUE;
			for (int j = i; j <= len; j++) {
				localMax[i][j] = Math.max(localMax[i][j - 1], globalMax[i - 1][j - 1] + nums[j - 1]);
				if (j == i) {
					globalMax[i][j] = localMax[i][j];
				} else {
					globalMax[i][j] = Math.max(globalMax[i][j - 1], localMax[i][j]);
				}
			}
		}
		return globalMax[k][len];
	}
	*/
}
