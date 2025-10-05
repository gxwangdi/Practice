public class FindTheMissingNumber {
	/**
	 * @param nums
	 *            : an array of integers
	 * @return: an integer
	 */
	public int findMissing(int[] nums) {
		if (nums == null) {
			return -1;
		}

		int cur = 0;
		while (cur < nums.length) {
			if (cur == nums[cur]) {
				// if consistent, nothing happens
				cur++;
				continue;
			}
			if (nums[cur] == nums.length || nums[nums[cur]] == nums[cur]) {
				// in case dead loop
				cur++;
				continue;
			}
			swap(nums, cur, nums[cur]);
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i) {
				return i;
			}
		}
		return nums.length;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
