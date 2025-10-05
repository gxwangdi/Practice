public class PartitionArrayByOddAndEven {
	/**
	 * @param nums
	 *            : an array of integers
	 * @return: nothing
	 */
	public void partitionArray(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			while (nums[left] % 2 == 1 && left < nums.length) {
				left++;
			}
			while (nums[right] % 2 == 0 && right >= 0) {
				right--;
			}
			if (left < right) {
				swap(nums, left, right);
				left++;
				right--;
			}
		}
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}
