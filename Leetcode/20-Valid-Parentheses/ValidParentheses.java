public class ValidParentheses {
    
    
    public boolean isValid(String s) {
        if (s == null) return false;
        
        s = s.trim();
        int len;
        do {
            len = s.length();
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\[\\]", "");
            s = s.replaceAll("\\{\\}", "");
        } while (len != s.length());
        return s.length() == 0;
    }
    
    /*
    public boolean isValid(String s) {
        if (s == null) return false;
        
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else if (stack.empty()) return false;
            else if (c == ')' && stack.pop()!='(') return false;
            else if (c == ']' && stack.pop()!='[') return false;
            else if (c == '}' && stack.pop()!='{') return false;
        }
        return stack.empty();
    }*/
}



