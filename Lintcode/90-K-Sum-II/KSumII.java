import java.util.ArrayList;
import java.util.List;

public class KSumII {
	/**
	 * @param A: an integer array.
	 * @param k: a positive integer (k <= length(A))
	 * @param target: a integer
	 * @return a list of lists of integer
	 */
	private void dfs(int[] A, int K, int target, int index, List<Integer> tans, List<List<Integer>> ans) {
		if (K == 0 && target == 0) {
			ans.add(new ArrayList<Integer>(tans));
			return;
		}
		if (K < 0 || target < 0 || index < 0) {
			return;
		}
		// we do not take A[index] into result set.
		dfs(A, K, target, index - 1, tans, ans);

		// we take A[index] into result set.
		tans.add(A[index]);
		dfs(A, K - 1, target - A[index], index - 1, tans, ans);
		tans.remove(tans.size() - 1);
	}

	public List<List<Integer>> kSumII(int[] A, int k, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> tans = new ArrayList<>();
		dfs(A, k, target, A.length - 1, tans, ans);
		return ans;
	}
}
