
public class MoveZeroes {
	/**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                continue;
            }
            int j = i + 1;
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j == nums.length) {
                break;
            }
            swap(nums, i, j);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
