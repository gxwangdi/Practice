import java.util.ArrayList;
import java.util.List;

public class Permutations {
	/**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		res.add(list);
		if (nums == null || nums.length == 0) {
			return res;
		}
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> level = new ArrayList<>();
			for (List<Integer> l : res) {
				for (int j = 0; j <= l.size(); j++) {
					list = new ArrayList<>(l);
					list.add(j, nums[i]);
					level.add(list);
				}
			}
			res = level;
		}
		return res;
	}
}
