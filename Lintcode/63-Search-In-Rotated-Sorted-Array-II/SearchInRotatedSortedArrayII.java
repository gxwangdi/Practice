
public class SearchInRotatedSortedArrayII {
	/** 
     * param nums : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return true;
			}
		}
		return false;
	}
}
