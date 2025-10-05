import java.util.LinkedList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+') {
                String s1 = input.substring(0,i);
                String s2 = input.substring(i+1);
                List<Integer> part1Res = diffWaysToCompute(s1);
                List<Integer> part2Res = diffWaysToCompute(s2);
                for (Integer p1 : part1Res) {
                    for (Integer p2 : part2Res) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+':
                                c = p1+p2;
                                break;
                            case '-':
                                c = p1-p2;
                                break;
                            case '*':
                                c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add( Integer.valueOf(input) );
        }
        return ret;    
    }
    
    /*
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();       
        if (input == null || input.length()<3) {
            return res;
        }
        
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> symbols = new Stack<>();  
        // Not assuming all numbers are single digit, collect char by char.
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        char c = input.charAt(cur);       
        while ( Character.isDigit(c) ) {
            sb.append(c);
            cur ++;
            if (cur >= input.length()) {
                break;
            }
            c = input.charAt(cur);
        }
        numbers.push(Integer.parseInt(sb.toString()));
        helper(res, numbers, symbols, input, cur);
        return res;
    }// end of diffWaysToCompute      
    
    
    private void helper(List<Integer> res, Stack<Integer> num, Stack<Character> sym, String input, int cur) {
        if (cur >= input.length()) {
            while (num.size() > 1) {
                int a = num.pop();
                int b = num.pop();
                char c = sym.pop();
                switch (c) {
                    case '+':
                        num.push(a+b);
                        break;
                    case '-':
                        num.push(a-b);
                        break;
                    case '*':
                        num.push(a*b);
                        break;
                }// end of c
            }
            res.add(num.pop());
            return;
        }// wrap up
        // assuming symbols are +-*, one digit.
        char c = input.charAt(cur++);
        sym.push(c);
        // assuming all inputs are valid, there must be a number following a symbol.
        StringBuilder sb = new StringBuilder();     
        c = input.charAt(cur);
        while ( Character.isDigit(c) ) {
            sb.append(c);
            cur++;
            if (cur >= input.length()) {
                break;
            }
            c = input.charAt(cur);
        }
        int n = Integer.parseInt(sb.toString());  
        // Do not take it.
        Stack<Character> sym2 = new Stack<Character>(sym);      
        Stack<Integer> num2 = new Stack<Integer>(num);
        nums.push(n);
        helper(res, num2, sym2, input, cur);
        // Take it.
        c = sym.pop();
        int m = num.pop();
        switch (c) {
            case '+':
                num.push(m+n);
                break;
            case '-':
                num.push(m-n);
                break;
            case '*':
                num.push(m*n);
                break;
        }
        helper(res, num, sym, input, cur);
    }// end of helper          
    */
    
}// end of Solution class        








