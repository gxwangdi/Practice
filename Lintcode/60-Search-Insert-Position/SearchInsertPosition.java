
public class SearchInsertPosition {
	/** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    // Iterative approcah
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] >= target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (nums[start] >= target) {
			return start;
		}
		if (nums[end] < target) {
			return end + 1;
		}
		return end;
	}
     
    /* // jiuzhang official recursive answer
    public int searchInsert(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return searchInsert(nums, target, 0, nums.length - 1);
    }
    private int searchInsert(int[] nums, int target, int left, int right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return mid > left ? searchInsert(nums, target, left, mid - 1) : left;
        } else {
            return mid < right ? searchInsert(nums, target, mid + 1, right) : (right + 1);
        }
    }*/    
}
