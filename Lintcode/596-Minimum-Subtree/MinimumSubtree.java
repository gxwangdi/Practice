
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
public class MinimumSubtree {
	/**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
	public TreeNode findSubtree(TreeNode root) {
		getBranchSum(root);
		if (result == null) {
			return null;
		}
		return result.root;
	}

	private Result result = null;

	private Result getBranchSum(TreeNode node) {
		if (node == null) {
			return new Result(null, 0);
		}

		Result left = getBranchSum(node.left);
		Result right = getBranchSum(node.right);
		Result cur = new Result(node, left.sum + right.sum + node.val);

		if (result == null || cur.sum < result.sum) {
			result = cur;
		}
		return cur;
	}

	private static class Result {
		public int sum;
		public TreeNode root;

		public Result(TreeNode r, int s) {
			root = r;
			sum = s;
		}
	}
}
