import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        res.add(list);
        // Arrays.sort(nums); // if order does not matter.
        for (int i=0; i < nums.length; i++) {
            List<List<Integer>> level = new ArrayList<>();
            for (List<Integer> l : res) {
                list = new ArrayList<>(l);
                list.add(nums[i]);
                level.add(list);
            }
            res.addAll(level);
        }
        return res;
    }// end of subsets    
}




