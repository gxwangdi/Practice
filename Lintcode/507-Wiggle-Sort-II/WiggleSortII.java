
public class WiggleSortII {
	/**
	 * @param nums a list of integer
	 * @return void
	 */
	// Space O(n), easier to understand version.
	public void wiggleSort(int[] nums) {
		int median = findKthLargest(nums, (nums.length + 1) / 2);
		int odd = 1;
		int even = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
		int[] tmpArr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > median) {
				tmpArr[odd] = nums[i];
				odd += 2;
				continue;
			}
			if (nums[i] < median) {
				tmpArr[even] = nums[i];
				even -= 2;
				continue;
			}
		}
		while (odd < nums.length) {
			tmpArr[odd] = median;
			odd += 2;
		}
		while (even >= 0) {
			tmpArr[even] = median;
			even -= 2;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = tmpArr[i];
		}
	}

	/*
	// Index Mapping.
	public void wiggleSort(int[] nums) {
		int median = findKthLargest(nums, (nums.length + 1) / 2);
		int n = nums.length;
		int left = 0, i = 0, right = n - 1;
		while (i <= right) {
			if (nums[newIndex(i, n)] > median) {
				swap(nums, newIndex(left++, n), newIndex(i++, n));
			} else if (nums[newIndex(i, n)] < median) {
				swap(nums, newIndex(right--, n), newIndex(i, n));
			} else {
				i++;
			}
		}
	}

	private int newIndex(int index, int n) {
		return (1 + 2 * index) % (n | 1);
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}*/

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return 0;
		}
		// Pay attention to the position, the kth largest in an ascending array is at
		// position len-k+1
		return helper(nums, 0, nums.length - 1, nums.length - k + 1);
	}

	private int helper(int[] nums, int l, int r, int k) {
		if (l == r) {
			return nums[l];
		}

		int position = partition(nums, l, r);
		if (position + 1 == k) { // Pay attention to index and kth element.
			return nums[position];
		} else if (position + 1 < k) {
			return helper(nums, position + 1, r, k); // Always absolut position to avoid a lot of issues!
		} else {
			return helper(nums, l, position - 1, k);
		}
	}// end of helper

	private int partition(int[] nums, int start, int end) {
		int left = start;
		int right = end;
		int pivot = nums[left];
		while (left < right) {
			while (left < right && nums[right] >= pivot) {
				right--;
			}
			nums[left] = nums[right];// pivot is persisted, pay attention to how it reduces implementation
										// complexity.
			while (left < right && nums[left] < pivot) {
				left++;
			}
			nums[right] = nums[left];
		}

		nums[left] = pivot;
		return left;
	}
}
