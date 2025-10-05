
public class RemoveDuplicatesFromSortedArray {
	/**
     * @param A: a array of integers
     * @return : return an integer
     */
	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			return -1;
		}
		if (nums.length < 2) {
			return nums.length;
		}
		int i = 0;
		int j = 1;
		while (j < nums.length) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
			j++;
		}
		return i + 1;
	}
}
