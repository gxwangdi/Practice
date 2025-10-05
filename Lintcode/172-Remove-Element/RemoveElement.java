
public class RemoveElement {
	/** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
	public int removeElement(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			while (i < j && nums[i] != target) {
				i++;
			}
			if (i == j) {
				continue;
			}
			while (i < j && nums[j] == target) {
				j--;
			}
			if (i == j) {
				continue;
			}
			swap(nums, i, j);
			i++;
			j--;
		}
		if (nums[i] == target) {
			return i;
		}
		return i + 1;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
