import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisionSubset {
	/**
	 * @param nums
	 *            a set of distinct positive integers
	 * @return the largest subset
	 */
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		if (nums.length == 0) {
			return ans;
		}
		Arrays.sort(nums);
		int n = nums.length;
		int[] dp = new int[n];
		int[] index = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(index, -1);
		int maxIndex = 0;
		int maxDp = 1;
		for (int i = 0; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					index[i] = j;
				}
			}
			if (maxDp < dp[i]) {
				maxDp = dp[i];
				maxIndex = i;
			}
		}
		for (int i = maxIndex; i != -1; i = index[i]) {
			ans.add(nums[i]);
		}
		return ans;
	}
}
