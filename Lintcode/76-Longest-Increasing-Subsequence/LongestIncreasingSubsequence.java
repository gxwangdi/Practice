import java.util.Arrays;


public class LongestIncreasingSubsequence {
	/**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    // jiuzhang official answer
	public int longestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int max = 0;
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i]) {
					dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
				}
			}
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}
    
    /*
     // My dp implementation, do not need to check back, maintain max and last.
     // Does not work quite well for [10,1,11,2,12,3,11]
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = nums[0];
        int last = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                dp[i] = 1;
                if (dp[i-1] > dp[last]) {
                    last = i-1;
                }
            } else {
                dp[i] = dp[i-1] + 1;
                if (nums[i] < nums[last] && dp[i] > dp[last]) {
                    max = nums[i];
                    last = i;
                } else if (dp[last] >= dp[i] && nums[i] > nums[last]) {
                    dp[i] = dp[last] + 1;
                    max = nums[i];
                    last = i;
                } 
            }
        }
        max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }
    */
}
