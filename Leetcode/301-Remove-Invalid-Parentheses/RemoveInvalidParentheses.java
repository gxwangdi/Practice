import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }
    
    private void remove(String src, List<String> res, int last_i, int last_j, char[] par) {
        for(int stack =0, i = last_i; i < src.length(); i++) {
            if (src.charAt(i) == par[0]) stack++;
            if (src.charAt(i) == par[1]) stack--;
            if (stack >=0) continue;
            
            // remove the first invalid thing to make sure the prefix is valid.
            for (int j = last_j; j<=i; j++) {
                if (src.charAt(j) == par[1] && (j == last_j || src.charAt(j-1)!=par[1])) {
                    remove(src.substring(0,j) + src.substring(j+1, src.length()), res, i, j, par);
                }
            }
            return;
        }
        
        String reversed = new StringBuilder(src).reverse().toString();
        if (par[0] == '(') {
            remove(reversed, res, 0, 0, new char[]{')', '('});
        } else {
            res.add(reversed);
        }
    }
    
    /*
    // Cannot resolve this case ")(", that is, some invalid chars appear ahead. 
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();   
        if (s == null) {
            return res;
        }
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                max++;
            }
            if (c == ')') {
                max--;
            }
        }
        max = Math.abs(max);
        Set<String> set = new HashSet<>(); // there could be duplicate result on leaf nodes. 
        helper(set, s, 0, "", 0, max);
        res.addAll(set);
        return res;
    }
    
    private void helper(Set<String> res, String src, int cur, String prog, int left, int max) {
        if (left < 0) { // invalid case, no need to proceed.
            return;
        }
        if (cur == src.length()) {
            if (max == 0 && left == 0) {
                res.add(prog);
            }
            return;
        }
        char c = src.charAt(cur); 
        if (c == '(') {
            helper(res, src, cur+1, prog+c, left+1, max);
            helper(res, src, cur+1, prog, left, max-1);
        } else if (c == ')') {
            helper(res, src, cur+1, prog+c, left-1, max);
            helper(res, src, cur+1, prog, left, max-1);
        } else {
            helper(res, src, cur+1, prog+c, left, max);
        }
    }
    */
    
    
    /*
    // iteration is way more complicated, my solution does not work for now. 
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();   
        if (s == null || s.length() == 0) {
            return list;
        }
        String left = headToRight();
        String right = tailToLeft();
        list.add(left);
        if (!left.equals(right)) {
            list.add(right);
        }
        return list;
    }
    
    private String headToRight(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c != ')') {
                stack.push(c);
                continue;
            }
            
            
        }
        return sb.toString();
    }
    
    private String tailToLeft(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            
        }
        return sb.toString();
    }
    */
}






