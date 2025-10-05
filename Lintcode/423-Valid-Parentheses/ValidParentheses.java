import java.util.Stack;


public class ValidParentheses {
	/**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
     /*
    public boolean isValidParentheses(String s) {
        // Write your code here
        if (s == null || s.length()==0) {
            return true;
        }
        int size;
        do {
            size = s.length();
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\[\\]", "");
            s = s.replaceAll("\\{\\}", "");
        } while (size != s.length());
        return s.length() == 0;
    }*/
    
	public boolean isValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
			case '[':
			case '{':
				stack.push(c);
				break;
			case ')':
				if (stack.empty() || stack.pop() != '(')
					return false;
				break;
			case ']':
				if (stack.empty() || stack.pop() != '[')
					return false;
				break;
			case '}':
				if (stack.empty() || stack.pop() != '{')
					return false;
				break;
			default:
				// /
			}
		}
		return stack.empty();
	}
}
