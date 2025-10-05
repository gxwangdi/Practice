
public class RemoveDuplicatesFromSortedArrayII {
	/**
     * @param A: a array of integers
     * @return : return an integer
     */
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		final int dup = 2;
		int counter = 1;
		int i = 0;
		int j = 1;
		while (j < nums.length) {
			if (nums[i] != nums[j]) {
				counter = 1;
				i++;
				nums[i] = nums[j];
			} else {
				if (counter < dup) {
					counter++;
					i++;
					nums[i] = nums[j];
				}
			}
			j++;
		}
		return i + 1;
	}
}
