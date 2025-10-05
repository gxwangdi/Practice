import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        
        helper(res, s, 0, new ArrayList<String>());
        return res;
    }
    
    private void helper(List<List<String>> res, String s, int cur, List<String> prog) {
        if (cur >= s.length()) {
            if (!prog.isEmpty()) {
                res.add(prog);
            }
            return;
        }
        
        for (int i=cur+1; i<=s.length(); i++) {
            if (!isPalindrome(s, cur, i)) {
                continue;
            }
            String p = s.substring(cur,i);
            List<String> list = new ArrayList<>(prog);
            list.add(p);
            helper(res, s, i, list);
        }
    }// end of helper
    
    private boolean isPalindrome(String s, int start, int end) {
        int i = start;
        int j = end-1;
        while (i<=j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }// end of isPalindrome
}





