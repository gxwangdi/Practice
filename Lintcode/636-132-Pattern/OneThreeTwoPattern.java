
public class OneThreeTwoPattern {
	/**
     * @param nums a list of n integers
     * @return true if there is a 132 pattern or false
     */
	public boolean find132pattern(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}
		for (int i = nums.length - 1; i >= 2; i--) {
			int j = i - 1;
			int k = 0;
			while (j > k) {
				if (nums[i] > nums[k] && nums[i] < nums[j])
					return true;
				if (nums[i] <= nums[k])
					k++;
				if (nums[i] >= nums[j])
					j--;
			}
		}
		return false;
	}
     
    // public boolean find132pattern(int[] nums) {
    //     if (nums == null || nums.length < 3) {
    //         return false;
    //     }
    //     int cur = 0;
    //     while (cur < nums.length-2) {
    //         if (nums[cur] < nums[cur+2]
    //         && nums[cur+2] < nums[cur+1]) {
    //             return true;
    //         }
    //         if (nums[cur+2] > nums[cur+1]) {
    //             cur ++;
    //             continue;
    //         }
    //         cur += 2;
    //     }
    //     return false;
    // }
}
