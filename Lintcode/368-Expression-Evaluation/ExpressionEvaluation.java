import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionEvaluation {
	/*
	 * @param expression: a list of strings
	 * 
	 * @return: an integer
	 */
	public int evaluateExpression(String[] expression) {
		Stack<String> stack = new Stack<>();
		Queue<String> queue = new LinkedList<>();
		for (String op : expression) {
			if ("+-*/".contains(op)) {
				if (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(op)) {
					queue.offer(stack.pop());
				}
				stack.push(op);
			} else if ("(".equals(op)) {
				stack.push(op);
			} else if (")".equals(op)) {
				while (!"(".equals(stack.peek())) {
					queue.offer(stack.pop());
				}
				stack.pop();
			} else {
				queue.offer(op);
			}
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
		return evaluateRPN(queue);
	}

	private int getPriority(String op) {
		char c = op.charAt(0);
		if (c == '+' || c == '-') {
			return 1;
		} else if (c == '*' || c == '/') {
			return 2;
		}
		return 0;
	}

	private int evaluateRPN(Queue<String> rpn) {
		Stack<Integer> stack = new Stack<>();
		while (!rpn.isEmpty()) {
			String op = rpn.poll();
			if ("+-*/".contains(op)) {
				int result = 0;
				int b = stack.pop();
				int a = stack.pop();
				if (op.equals("+")) {
					result = a + b;
				} else if (op.equals("-")) {
					result = a - b;
				} else if (op.equals("*")) {
					result = a * b;
				} else if (op.equals("/")) {
					result = a / b;
				}
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(op));
			}
		}
		if (stack.isEmpty())
			return 0;
		return stack.pop();
	}
}
