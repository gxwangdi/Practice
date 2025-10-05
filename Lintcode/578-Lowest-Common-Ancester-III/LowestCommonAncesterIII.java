
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
public class LowestCommonAncesterIII {
	/**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null) {
			return null;
		}
		Result res = getAncestor(root, A, B);
		if (res.aExist && res.bExist) {
			return res.node;
		}
		return null;
	}

	private Result getAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null) {
			return new Result(false, false, null);
		}
		Result left = getAncestor(root.left, A, B);
		Result right = getAncestor(root.right, A, B);
		boolean a = left.aExist || right.aExist || root == A;
		boolean b = left.bExist || right.bExist || root == B;
		if (root == A || root == B) {
			return new Result(a, b, root);
		}
		if (left.node != null && right.node != null) {
			return new Result(a, b, root);
		}
		if (left.node != null) {
			return new Result(a, b, left.node);
		}
		if (right.node != null) {
			return new Result(a, b, right.node);
		}
		return new Result(a, b, null);
	}

	private static class Result {
		public boolean aExist, bExist;
		public TreeNode node;

		public Result(boolean a, boolean b, TreeNode tn) {
			aExist = a;
			bExist = b;
			node = tn;
		}
	}
}
