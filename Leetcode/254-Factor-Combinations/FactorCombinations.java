import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <4) {
            return res;
        }
        helper(res, n, -1, new ArrayList<Integer>());
        return res;
    }
    
    // Add smaller divider in current level recusion, bigger divider in next level recursion.
    private void helper(List<List<Integer>> res, int n, int a, List<Integer> prog) {
        if (a != -1) {
            List<Integer> list = new ArrayList<>(prog);
            list.add(n);
            res.add(list);
        }
        
        int upper = (int)Math.sqrt(n);
        int cur = Math.max(2, a);
        while (cur <= upper) {
            if (n%cur == 0) {
                List<Integer> list = new ArrayList<>(prog);
                list.add(cur);
                helper(res, n/cur, cur, list);
            }
            cur++;
        }
    }// end of helper    
}





