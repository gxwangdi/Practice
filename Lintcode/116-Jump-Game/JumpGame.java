import java.util.Arrays;

public class JumpGame {
	/**
	 * @param A: A list of integers
	 * @return: The boolean answer
	 */
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0) {
			return true;
		}
		boolean[] dp = new boolean[A.length];
		Arrays.fill(dp, false);
		dp[0] = true;
		int cur = 0;
		for (int i = 0; i < A.length; i++) {
			if (!dp[i]) {
				continue;
			}
			int ceiling = i + A[i];
			if (ceiling <= cur) {
				continue;
			}
			if (ceiling >= A.length - 1) {
				return true;
			}
			while (cur <= ceiling) {
				dp[cur] = true;
				cur++;
			}
		}
		return dp[A.length - 1];
	}
}
