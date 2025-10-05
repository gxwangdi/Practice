public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}


