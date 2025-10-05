
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
public class BinaryTreeMaximumPathSum {
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		maxPathSum(root, max);
		return max[0];
	}

	private int maxPathSum(TreeNode node, int[] max) {
		if (node == null) {
			return 0;
		}
		int left = maxPathSum(node.left, max);
		left = Math.max(left, 0);
		int right = maxPathSum(node.right, max);
		right = Math.max(right, 0);
		max[0] = Math.max(max[0], left + node.val + right);
		return Math.max(left, right) + node.val;
	}
}
