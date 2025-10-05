import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }
    
    private void helper(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                res.add(path);
            }
            return;
        }
        for (int i=pos; i<num.length(); i++) {
            if (i!=pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1)); 
            if(pos == 0){
                helper(res, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(res, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
                helper(res, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                
                helper(res, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            } 
        }
    }// end of helper
    
    /*
    // My implementation is too long and does not handle "10-5" case. It is assuming every single digit is appended by a symbol. 
    char[] symbols = {'+', '-', '*'};
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        helper(res, new StringBuilder(), num, 0, target);
        return res;
    }
    
    private void helper(List<String> res, StringBuilder sb, String num, int cur, int target) {
        sb.append(num.charAt(cur));
        cur++;
        if (cur >= num.length()) {
            // sb.deleteCharAt(sb.length()-1);
            int result = getResult(sb.toString());
            if (result == target) {
                res.add(sb.toString());
            }
            return;
        }
        // for (int i=0; i<symbols.length; i++) 
        for (char c : symbols)
        {
            StringBuilder prog = new StringBuilder(sb);
            prog.append(c);
            // prog.append(symbols[i]);
            helper(res, prog, num, cur, target);
        }
        // Do not append anything.   
        helper(res, new StringBuilder(sb), num, cur, target);
    }
    
    // Based on expression, get an integer as a result.    
    private int getResult(String s) {
        if (s == null || s.length()%2 == 0) {
            return 0;
        }
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> symbols = new Stack<>();
        boolean isStar = false;
        int temp = 0;
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                int a = cur-'0';
                temp = temp*10+a;
                continue;
            } 
            if (isStar) {
                isStar = false;
                int b = numbers.pop();
                temp *= b;
            }
            numbers.push(temp);
            temp = 0;
            if (cur == '*') {
                isStar = true;
            } else {
                symbols.push(cur);
            }
        }
        numbers.push(temp);
        
        int sum = 0;
        while (!symbols.empty()) {
            int a = numbers.pop();
            char b = symbols.pop();
            if (b == '+') {
                sum += a;
            } else { // s == '-'
                sum -= a;
            }
        }
        return sum + numbers.pop();
    }
    */
}







