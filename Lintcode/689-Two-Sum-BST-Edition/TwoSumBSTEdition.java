import java.util.Stack;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class TwoSumBSTEdition {
	/*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
	public int[] twoSum(TreeNode A, int B) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		TreeNode cur1 = A;
		TreeNode cur2 = A;

		while (!stack1.isEmpty() || !stack2.isEmpty() || cur1 != null || cur2 != null) {
			if (cur1 != null || cur2 != null) {
				if (cur1 != null) {
					stack1.push(cur1);
					cur1 = cur1.left;
				}

				if (cur2 != null) {
					stack2.push(cur2);
					cur2 = cur2.right;
				}
			} else {
				int val1 = stack1.peek().val;
				int val2 = stack2.peek().val;

				// need to break out of here
				if (stack1.peek() == stack2.peek())
					break;

				if (val1 + val2 == B) {
					int[] result = new int[2];
					result[0] = val1;
					result[1] = val2;
					return result;
				}

				if (val1 + val2 < B) {
					cur1 = stack1.pop();
					cur1 = cur1.right;
				} else {
					cur2 = stack2.pop();
					cur2 = cur2.left;
				}
			}
		}
		return null;
	}
}
