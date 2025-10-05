import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n<= k) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), 1, k, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> prog, int start, int k, int n) {
        if (k == 0) {
            if (n == 0) {
                res.add(prog);
            }
            return;
        }
        for (int i=start; i<=9; i++) {
            List<Integer> list = new ArrayList<>(prog);
            list.add(i);
            helper(res, list, i+1, k-1, n-i);
        }
    }// end of helper      
}



