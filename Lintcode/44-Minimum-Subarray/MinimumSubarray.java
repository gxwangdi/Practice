import java.util.ArrayList;


public class MinimumSubarray {
	/**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        int res = Integer.MAX_VALUE;
        if (nums == null || nums.size()==0) {
            return res;
        }
        int minSum = 0;
        for (int i=0; i<nums.size(); i++) {
            minSum = Math.min(minSum + nums.get(i), nums.get(i));
            res = Math.min(minSum, res);
        }
        return res;
    }
}
