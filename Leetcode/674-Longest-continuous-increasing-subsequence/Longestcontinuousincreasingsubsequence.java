

class Longestcontinuousincreasingsubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int max = 1;
        int len = 1;
        int cur = nums[0];
        for(int i =1; i<nums.length; i++) {
            if (nums[i] > cur) {
                len++;
                max = Math.max(max, len);
            } else {
                len = 1;
            }
            cur = nums[i];
        }
        return max;
    }
}
