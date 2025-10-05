import java.util.Arrays;


public class RemoveDuplicateNumbersInArray {
	/**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        Arrays.sort(nums);
        int index = 0;
        int checker = 1;
        while (checker < nums.length) {
            if (nums[index] != nums[checker]) {
                nums[index + 1] = nums[checker];
                index++;
            }
            checker++;
        }
        return index + 1;
    }
}
