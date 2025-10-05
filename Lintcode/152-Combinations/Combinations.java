import java.util.ArrayList;
import java.util.List;


public class Combinations {
	/**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (n < 1 || k < 1) {
			return res;
		}
		List<Integer> progress = new ArrayList<Integer>();
		getCombinations(res, 1, n, progress, k);
		return res;
	}

	private void getCombinations(List<List<Integer>> res, int start, int end,
			List<Integer> prog, int k) {
		if (k == 0) {
			if (!res.contains(prog)) {
				res.add(prog);
			}
			return;
		}

		for (int i = start; i <= end; i++) {
			List<Integer> temp = new ArrayList<>(prog);
			temp.add(i);
			getCombinations(res, i + 1, end, temp, k - 1);
		}
	}// end of getCombinations
}
