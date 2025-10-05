import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        List<Integer> list = new ArrayList<>();
        res.add(list);
        Arrays.sort(nums);
        for (int i = 0; i<nums.length; i++) {
            List<List<Integer>> level = new ArrayList<>();
            for (List<Integer> l : res) {
                list = new ArrayList<>(l);
                list.add(nums[i]);
                if (!res.contains(list)) {
                    level.add(list);
                }
            }
            res.addAll(level);
        }
        return res;
    }
}



