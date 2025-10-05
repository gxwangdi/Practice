
public class FirstPositionOfTarget {
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    // From template
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        while (start + 1< end) {
            int mid = start + (end-start)/2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
     
    /* // From myself. Couple of submissions and bugs before it is accepted. 
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                while (mid >= 0 && nums[mid] == target) {
                    mid--;
                }
                if (mid == 0 && nums[mid] == target) {
                    return mid;
                } else {
                    return mid + 1;
                }
            }
            if (mid == left) {
                break;
            }
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
    */ 
}
