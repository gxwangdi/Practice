
public class WiggleSort {
	/**
     * @param nums a list of integer
     * @return void
     */
	public void wiggleSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 1) {
				if (nums[i - 1] > nums[i]) {
					swap(nums, i);
				}
			} else if (i != 0 && nums[i - 1] < nums[i]) {
				swap(nums, i);
			}
		}
	}// end of wiggleSort

	private void swap(int[] nums, int i) {
		int temp = nums[i];
		nums[i] = nums[i - 1];
		nums[i - 1] = temp;
	}
}
