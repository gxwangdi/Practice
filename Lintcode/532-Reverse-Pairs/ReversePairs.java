
public class ReversePairs {
	/**
	 * @param nums an array
	 * @return total of reverse pairs
	 */
	public long reversePairs(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		long sum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					sum++;
				}
			}
		}
		return sum;
	}

	/*
	public long reversePairs(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return mergeSort(nums, 0, nums.length - 1);
	}

	private int mergeSort(int[] nums, int start, int end) {
		if (start >= end) {
			return 0;
		}
		int mid = start + (end - start) / 2;
		int sum = 0;
		sum += mergeSort(nums, 0, mid);
		sum += mergeSort(nums, mid + 1, end);
		sum += merge(nums, start, mid, end);
		return sum;
	}

	private int merge(int[] nums, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int leftIndex = start;
		int rightIndex = mid + 1;
		int index = 0;
		int sum = 0;
		while (leftIndex <= mid && rightIndex <= end) {
			if (nums[leftIndex] <= nums[rightIndex]) {
				temp[index++] = nums[leftIndex++];
			} else {
				temp[index++] = nums[rightIndex++];
				sum += mid - leftIndex + 1;
			}
		}
		while (leftIndex <= mid) {
			temp[index++] = nums[leftIndex++];
		}
		while (rightIndex <= end) {
			temp[index++] = nums[rightIndex++];
		}
		for (int i = start; i <= end; i++) {
			nums[i] = temp[i - start];
		}
		return sum;
	}*/
}
