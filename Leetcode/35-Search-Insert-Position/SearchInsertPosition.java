public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return searchInsert(nums, target, 0, nums.length-1);
    }

    private int searchInsert(int[] nums, int target, int start, int end) {
        int mid = start + (end - start)/2;

        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return start < mid? searchInsert(nums, target, start, mid-1):start;
        } else {
            return end > mid? searchInsert(nums, target, mid+1, end):(end+1);
        }
    }
}
