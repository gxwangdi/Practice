public class Median {
	/**
	 * @param nums
	 *            : A list of integers.
	 * @return: An integer denotes the middle number of the array.
	 */
	public int median(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (nums.length % 2 == 1) {
			return findkth(nums, 0, nums.length - 1, nums.length / 2 + 1);
		} else {
			return findkth(nums, 0, nums.length - 1, nums.length / 2);
		}
	}

	private int findkth(int[] nums, int start, int end, int k) {
		if (k < 0 || k > end - start + 1) {
			return Integer.MAX_VALUE;
		}

		int pos = leftPartition(nums, start, end);
		if (pos - start == k - 1) {
			return nums[pos];
		}

		if (pos - start > k - 1) {
			return findkth(nums, start, pos - 1, k);
		}

		return findkth(nums, pos + 1, end, k - (pos - start) - 1);
	}

	private int leftPartition(int[] nums, int l, int r) {
		int target = nums[l];
		int pos = l + 1;
		for (int i = r; i >= pos; i--) {
			if (nums[i] < target) {
				swap(nums, pos, i);
				i++;
				pos++;
			}
		}
		pos--;
		swap(nums, l, pos);
		return pos;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
