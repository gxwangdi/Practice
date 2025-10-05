import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
	/**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        res.add(list);
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (Integer i : nums) {
            List<List<Integer>> level = new ArrayList<>();
            for (List<Integer> l : res) {
                for (int j = 0; j <= l.size(); j++) {
                    list = new ArrayList<>(l);
                    list.add(j, i);
                    if (!level.contains(list)) {
                        level.add(list);
                    }
                }
            }
            res = level;
        }
        return res;
    }
}
