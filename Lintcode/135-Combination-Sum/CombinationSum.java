import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	/**
	 * @param candidates
	 *            : A list of integers
	 * @param target
	 *            :An integer
	 * @return: A list of lists of integers
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0 || target <= 0) {
			return res;
		}
		Arrays.sort(candidates);
		List<Integer> progress = new ArrayList<>();
		getCombinations(candidates, 0, res, progress, target);
		return res;
	}

	private void getCombinations(int[] src, int start, List<List<Integer>> res,
			List<Integer> prog, int left) {
		for (int i = start; i < src.length; i++) {
			int val = left - src[i];
			if (val < 0) {
				continue;
			}
			List<Integer> list = new ArrayList<>(prog);
			list.add(src[i]);
			if (val == 0 && !res.contains(list)) {
				res.add(list);
				continue;
			}
			getCombinations(src, i, res, list, val);
		}
	}
}
