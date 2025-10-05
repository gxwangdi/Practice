import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertExpressionToReversePolishNotation {
	public List<String> convertToRPN(String[] expression) {
		List<String> list = new ArrayList<>();
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < expression.length; i++) {
			String str = expression[i];
			if (isOp(str)) {
				if (str.equals("(")) {
					stack.push(str);
				} else if (str.equals(")")) {
					while (!stack.isEmpty()) {
						String s = stack.pop();
						if (s.equals("(")) {
							break;
						}
						list.add(s);
					}
				} else {
					while (!stack.isEmpty() && order(str) <= order(stack.peek())) {
						list.add(stack.pop());
					}
					stack.push(str);
				}
			} else {
				list.add(str);
			}
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}

	// Hard code for all possible ops.
	private boolean isOp(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("(")
				|| str.equals(")")) {
			return true;
		} else {
			return false;
		}
	}

	private int order(String str) {
		if (str.equals("*") || str.equals("/")) {
			return 2;
		} else if (str.equals("+") || str.equals("-")) {
			return 1;
		} else {
			return 0;
		}
	}// end of order.
}
