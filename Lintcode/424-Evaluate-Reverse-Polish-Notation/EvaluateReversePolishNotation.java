import java.util.Stack;

public class EvaluateReversePolishNotation {
	/**
	 * @param tokens
	 *            The Reverse Polish Notation
	 * @return the value
	 */
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return Integer.MIN_VALUE;
		}
		Stack<Integer> stack = new Stack<>();
		String operator = "+-*/";
		for (int i = 0; i < tokens.length; i++) {
			String s = tokens[i];
			int index = operator.indexOf(s);
			if (index == -1) {
				int e = Integer.valueOf(s);
				stack.push(e);
				continue;
			}
			int a = stack.pop();
			int b = stack.pop();
			switch (index) {
			case 0:
				stack.push(a + b);
				break;
			case 1:
				stack.push(b - a);
				break;
			case 2:
				stack.push(a * b);
				break;
			case 3:
				stack.push(b / a);
				break;
			default:
				// /
			}
		}
		return stack.pop();
	}
}
