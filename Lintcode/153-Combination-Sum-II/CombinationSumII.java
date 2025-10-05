import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSumII {
	/**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (num == null || num.length == 0 || target <= 0) {
			return res;
		}

		Arrays.sort(num);
		List<Integer> prog = new ArrayList<>();
		getCombinations(num, 0, res, prog, target);
		return res;
	}

	private void getCombinations(int[] src, int start, List<List<Integer>> res,
			List<Integer> progress, int left) {
		for (int i = start; i < src.length; i++) {
			int val = left - src[i];
			if (val < 0) {
				continue;
			}
			List<Integer> list = new ArrayList<>(progress);
			list.add(src[i]);
			if (val == 0) {
				if (!res.contains(list)) {
					res.add(list);
				}
				continue;
			}
			getCombinations(src, i + 1, res, list, val);
		}
	}// end of getCombinations
}
