import java.util.Arrays;

public class JumpGameII {
  public int jump(int[] nums) {
      if (nums == null || nums.length == 0) {
          return -1;
      }
      if (nums.length == 1) {
          return 0;
      }
      int[] dp = new int[nums.length];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 0;
      int cur = 1;
      for (int i=0; i<nums.length; i++) {
          int far = i + nums[i];
          int value = dp[i] + 1;
          if (far >= nums.length-1) {
              return value;
          }
          if (far < cur) {
              continue;
          }
          while (cur <= far) {
              dp[cur] = value;
              cur++;
          }
      }
      return dp[nums.length-1];
  }
}
