import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
	public List<List<Integer>> subsetsWithDup(int[] S) {
		List<List<Integer>> res = new ArrayList<>();
		if (S == null || S.length == 0) {
			return res;
		}
		List<Integer> list = new ArrayList<>();
		res.add(list);
		Arrays.sort(S);
		for (int i = 0; i < S.length; i++) {
			List<List<Integer>> level = new ArrayList<>();
			for (List<Integer> l : res) {
				list = new ArrayList<>(l);
				list.add(S[i]);
				if (!res.contains(list)) {
					level.add(list);
				}
			}
			res.addAll(level);
		}
		return res;
	}
}
