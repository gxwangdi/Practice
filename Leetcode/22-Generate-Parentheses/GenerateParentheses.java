import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n<=0) {
            return res;
        }
        dfs(res, "", n, n);
        return res;
    }
    
    private void dfs(List<String> res, String parent, int left, int right) {
        if (left > right) {
            return; // invalid case like ")("
        }
        
        if (left == 0 && right == 0) {
            res.add(parent);
            return;
        }
        
        if (left > 0) {
            dfs(res, parent+"(", left-1, right);
        }
        
        if (right > 0) {
            dfs(res, parent+")", left, right-1);
        }
    }
}




