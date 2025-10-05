
public class MaximumSubarrayDifference {
	/**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
	public int maxDiffSubArrays(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] maxFromLeft = new int[nums.length];
		int[] minFromLeft = new int[nums.length];
		int min = nums[0];
		int max = min;
		int localmin = min;
		int localmax = max;
		maxFromLeft[0] = minFromLeft[0] = min;
		for (int i = 1; i < nums.length; i++) {
			localmin = Math.min(nums[i], localmin + nums[i]);
			localmax = Math.max(nums[i], localmax + nums[i]);
			max = Math.max(max, localmax);
			min = Math.min(min, localmin);
			maxFromLeft[i] = max;
			minFromLeft[i] = min;
		}
		min = nums[nums.length - 1];
		max = min;
		localmin = min;
		localmax = max;
		int res = Math.max(max - minFromLeft[nums.length - 2],
				maxFromLeft[nums.length - 2] - min);
		for (int i = nums.length - 2; i > 0; i--) {
			localmin = Math.min(nums[i], localmin + nums[i]);
			localmax = Math.max(nums[i], localmax + nums[i]);
			max = Math.max(max, localmax);
			min = Math.min(min, localmin);
			res = Math.max(res, Math.max(max - minFromLeft[i - 1],
					maxFromLeft[i - 1] - min));
		}
		return res;
	}
}
