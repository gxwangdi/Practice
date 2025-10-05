
public class SortColors {
	/**
	 * @param nums: A list of integer which is 0, 1 or 2
	 * @return: nothing
	 */
	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		int cur = 0;
		int left = 0;
		int right = nums.length - 1;
		while (left < nums.length) {
			while (left < nums.length && nums[left] == cur) {
				left++;
			}
			while (right >= 0 && nums[right] != cur) {
				right--;
			}
			if (left < right) {
				swap(nums, left, right);
				left++;
				right--;
			} else {
				right = nums.length - 1;
				cur++;
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
