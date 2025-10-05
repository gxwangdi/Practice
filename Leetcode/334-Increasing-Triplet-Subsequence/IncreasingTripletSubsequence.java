public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= small) {
                small = nums[i];
                continue;
            }
            if (nums[i] <= big) {
                big = nums[i];
                continue;
            }
            return true;
        }
        return false;
    }
}





