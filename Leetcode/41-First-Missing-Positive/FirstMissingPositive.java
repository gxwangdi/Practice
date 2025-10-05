public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            if (nums[i] > nums.length) {
                continue;
            }
            if (nums[nums[i]-1] == nums[i]) {
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[temp-1];
            nums[temp-1] = temp;
            i--;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}




