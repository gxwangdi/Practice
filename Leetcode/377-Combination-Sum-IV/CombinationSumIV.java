public class CombinationSumIV {
    
    
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }
        
        int[] dp = new int[target+1];
        dp[0] = 1; 
        for (int i=0; i<dp.length; i++) {
            if (dp[i] == 0) { // steps not reachable
                continue;
            }
            for (int num : nums) {
                if (i+num >= dp.length) {
                    continue;
                }
                dp[i+num] += dp[i];
            }
        }
        return dp[target];
    }
    
    
    /*
    // Brute force,  TLE.   
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] res = new int[1];
        res[0] = 0;
        getCombination(nums, res, target);
        return res[0];
    }
    
    private void getCombination(final int[] nums, final int[] res, final int progress) {
        for (int i : nums) {
            int val = progress - i;
            if (val == 0) {
                res[0] ++;
            } else if (val > 0) {
                getCombination(nums, res, val);
            }
        }
    }// end of getCombination   
    */
}





