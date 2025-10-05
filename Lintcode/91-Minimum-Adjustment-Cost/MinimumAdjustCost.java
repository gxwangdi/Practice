import java.util.ArrayList;

public class MinimumAdjustCost {
	/**
	 * @param A
	 *            : An integer array.
	 * @param target
	 *            : An integer.
	 */
	public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
		int len = A.size();
		int max = 0;
		for (int i = 0; i < len; i++) {
			max = Math.max(max, A.get(i));
		}
		int[][] dp = new int[len][max + 1];
		for (int j = 0; j <= max; j++) {
			dp[0][j] = Math.abs(A.get(0) - j);
		}
		int curMin = 0;
		for (int i = 1; i < len; i++) {
			curMin = Integer.MAX_VALUE;
			for (int j = 0; j <= max; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = Math.max(0, j - target); k <= Math.min(max, j
						+ target); k++) {
					dp[i][j] = Math.min(dp[i][j],
							dp[i - 1][k] + Math.abs(A.get(i) - j));
					curMin = Math.min(curMin, dp[i][j]);
				}
			}
		}
		return curMin;
	}
}
