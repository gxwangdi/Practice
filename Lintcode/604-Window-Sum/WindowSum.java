
public class WindowSum {
	/**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
	public int[] winSum(int[] nums, int k) {
		if (nums == null || nums.length < k || k < 1) {
			return new int[0];
		}
		int[] result = new int[nums.length - k + 1];
		int cur = 0;
		result[cur] = getInitialSum(nums, k);
		cur++;
		while (cur < result.length) {
			result[cur] = getSumForPosition(nums, cur, k, result[cur - 1]);
			cur++;
		}
		return result;
	}

	private int getInitialSum(final int[] nums, int k) {
		int result = 0;
		while (k > 0) {
			result += nums[k - 1];
			k--;
		}
		return result;
	}

	private int getSumForPosition(final int[] nums, int cur, int length, int sum) {
		// cur + length - 1 is garantteed to be smaller than nums.length.
		// cur bigger than 0.
		sum -= nums[cur - 1];
		sum += nums[cur + length - 1];
		return sum;
	}
}
