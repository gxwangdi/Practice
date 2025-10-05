import java.util.Arrays;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false); // boolean array is false by default.
        dp[0] = true;
        int cur = 0;
        for (int i=0; i<nums.length; i++) {
            if (!dp[i]) {
                return false;
            }
            int far = i + nums[i];
            if (far >= nums.length -1) {
                return true;
            }
            if (far < cur) {
                continue;
            }
            while (cur <= far) {
                dp[cur] = true;
                cur++;
            }
        }
        return dp[nums.length-1]; // take care this edge case. 
    }
}
