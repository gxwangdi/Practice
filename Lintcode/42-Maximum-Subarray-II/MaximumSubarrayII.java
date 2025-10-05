import java.util.ArrayList;

public class MaximumSubarrayII {
	/**
	 * @param nums: A list of integers
	 * @return: An integer denotes the sum of max two non-overlapping subarrays
	 */
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
		int res = Integer.MIN_VALUE;
		if (nums == null || nums.size() == 0) {
			return res;
		}

		int size = nums.size();
		int[] left = new int[size];
		int[] right = new int[size];

		// Init left
		int sum = 0;
		int minSum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			sum += nums.get(i);
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
			left[i] = max;
		}

		// Init right
		sum = 0;
		minSum = 0;
		max = Integer.MIN_VALUE;
		for (int i = size - 1; i >= 0; i--) {
			sum += nums.get(i);
			max = Math.max(max, sum - minSum);
			minSum = Math.min(sum, minSum);
			right[i] = max;
		}

		for (int i = 0; i < size - 1; i++) {
			res = Math.max(res, left[i] + right[i + 1]);
		}
		return res;
	}
}
