import java.util.Stack;

public class ExpressionExpand {
	/**
	 * @param s
	 *            an expression includes numbers, letters and brackets
	 * @return a string
	 */
	public String expressionExpand(String s) {
		Stack<Object> stack = new Stack<>();
		int number = 0;
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				number = number * 10 + (c - '0');
			} else if (c == '[') {
				stack.push(Integer.valueOf(number));
				number = 0;
			} else if (c == ']') {
				String temp = popStack(stack);
				Integer count = (Integer) stack.pop();
				while (count > 0) {
					stack.push(temp);
					count--;
				}
			} else {
				stack.push(String.valueOf(c));
			}
		}
		return popStack(stack);
	}// end of expressionExpand

	private String popStack(Stack<Object> stack) {
		Stack<String> container = new Stack<>();
		while (!stack.empty() && (stack.peek() instanceof String)) {
			container.push((String) stack.pop());
		}
		StringBuilder sb = new StringBuilder();
		while (!container.empty()) {
			sb.append(container.pop());
		}
		return sb.toString();
	}
}
