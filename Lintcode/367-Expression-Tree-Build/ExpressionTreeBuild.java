import java.util.Stack;

class ExpressionTreeNode {
	public String symbol;
	public ExpressionTreeNode left, right;

	public ExpressionTreeNode(String symbol) {
		this.symbol = symbol;
		this.left = this.right = null;
	}
}

public class ExpressionTreeBuild {
	/**
	 * @param expression:
	 *            A string array
	 * @return: The root of expression tree
	 */
	public ExpressionTreeNode build(String[] expression) {
		Stack<ExpressionTreeNode> op = new Stack<ExpressionTreeNode>();
		Stack<ExpressionTreeNode> data = new Stack<ExpressionTreeNode>();
		for (int i = 0; i < expression.length; i++) {
			String tmp = expression[i];
			char firstc = tmp.charAt(0);
			if (!(firstc <= '9' && firstc >= '0')) {
				// System.out.println("get op "+ tmp);
				switch (firstc) {
				case '(':
					ExpressionTreeNode node = new ExpressionTreeNode(tmp);
					op.push(node);
					break;
				case '+':
				case '-':
					while (!op.isEmpty() && op.peek().symbol.charAt(0) != '(') {
						ExpressionTreeNode opnode = op.pop();
						ExpressionTreeNode data1 = data.pop();
						ExpressionTreeNode data2 = data.pop();
						opnode.left = data2;
						opnode.right = data1;
						data.push(opnode);
					}
					ExpressionTreeNode node2 = new ExpressionTreeNode(tmp);
					op.push(node2);
					break;
				case '*':
				case '/':
					while (!op.isEmpty() && (op.peek().symbol.charAt(0) == '*' || op.peek().symbol.charAt(0) == '/')) {
						ExpressionTreeNode opnode = op.pop();
						ExpressionTreeNode data1 = data.pop();
						ExpressionTreeNode data2 = data.pop();
						opnode.left = data2;
						opnode.right = data1;
						data.push(opnode);
					}
					ExpressionTreeNode node3 = new ExpressionTreeNode(tmp);
					op.push(node3);
					break;
				case ')':
					while (op.peek().symbol.charAt(0) != '(') {
						ExpressionTreeNode opnode = op.pop();
						ExpressionTreeNode data1 = data.pop();
						ExpressionTreeNode data2 = data.pop();
						opnode.left = data2;
						opnode.right = data1;
						data.push(opnode);
					}
					op.pop();
				}
			} else {
				// System.out.println("add data "+tmp);
				ExpressionTreeNode data1 = new ExpressionTreeNode(tmp);
				data.push(data1);
			}
		}
		while (!op.isEmpty()) {
			ExpressionTreeNode opnode = op.pop();
			ExpressionTreeNode data1 = data.pop();
			ExpressionTreeNode data2 = data.pop();
			opnode.left = data2;
			opnode.right = data1;
			data.push(opnode);
		}
		if (data.isEmpty())
			return null;
		return data.pop();
	}
}
