import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k<=0 || n<k) {
            return res;
        }
        
        buildCombinations(res, 1, n, k, new ArrayList<Integer>());
        return res;
    }
    
    private void buildCombinations(List<List<Integer>> res, int start, int end, final int k, List<Integer> prog) {
        if (prog.size() == k) {
            res.add(prog);
            return;
        }
        if (start > end) {
            return;
        }
        for (int cur = start; cur <= end; cur++) {
            List<Integer> list = new ArrayList<>(prog);
            list.add(cur);
            buildCombinations(res, cur+1, end, k, list);
        }
    }
}





