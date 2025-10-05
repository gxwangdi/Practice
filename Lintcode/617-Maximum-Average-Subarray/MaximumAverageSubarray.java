public class MaximumAverageSubarray {
	/**
	 * @param nums an array with positive and negative numbers
	 * @param k an integer
	 * @return the maximum average
	 */
	public double maxAverage(int[] nums, int k) {
		double beg = Integer.MAX_VALUE;
		double end = Integer.MIN_VALUE;
		for (int n : nums) {
			if (beg > n) {
				beg = n;
			}
			if (end < n) {
				end = n;
			}
		}
		while (end - beg >= 1e-6) {
			double mid = beg + (end - beg) / 2.0;
			if (valid(nums, k, mid)) {
				beg = mid;
			} else {
				end = mid;
			}
		}
		return end;
	}

	private boolean valid(int[] nums, int k, double mid) {
		double min_pre = 0;
		double[] sum = new double[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1] - mid;
			if (i >= k && sum[i] - min_pre >= 0) {
				return true;
			}
			if (i >= k) {
				min_pre = Math.min(min_pre, sum[i - k + 1]);
			}
		}
		return false;
	}
}
