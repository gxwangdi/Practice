import java.util.Stack;

public class EvaluateREversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        String operator = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            int pos = operator.indexOf(tokens[i]);
            if ( pos == -1) {
                stack.push(Integer.parseInt(tokens[i]));
                continue;
            }
            
            int a = stack.pop();
            int b = stack.pop();
            switch (pos) {
                case 0:
                    stack.push(a+b);
                    break;
                case 1:
                    stack.push(b-a);
                    break;
                case 2:
                    stack.push(a*b);
                    break;
                case 3:
                    stack.push(b/a);
                    break;
                default:
                    //
            }
        }
        return stack.pop();
    }
}




