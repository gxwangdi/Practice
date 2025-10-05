import java.util.ArrayList;
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
public class SearchRangeInBinarySearchTree {
	/**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		ArrayList<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				if (k1 <= node.val && node.val <= k2) {
					res.add(node.val);
				}
				if (node.val > k2) {
					return res;
				}
				node = node.right;
			}
		}
		return res;
	}
}
