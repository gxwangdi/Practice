


public class LastPositionOfTarget {
	/**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    // From binary search template
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        while (start + 1 < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid-1;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}


