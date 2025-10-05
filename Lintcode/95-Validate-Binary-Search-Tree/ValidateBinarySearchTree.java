
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
public class ValidateBinarySearchTree {
	/**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		Result r = isValid(root);
		return r.isValid;
	}

	private Result isValid(TreeNode node) {
		Result res = new Result(true, node.val, node.val);
		if (node.left != null) {
			Result left = isValid(node.left);
			res.isValid &= left.isValid;
			if (left.max >= node.val) {
				res.isValid = false;
				return res;
			} else {
				res.min = left.min;
			}
		}
		if (node.right != null) {
			Result right = isValid(node.right);
			res.isValid &= right.isValid;
			if (right.min <= node.val) {
				res.isValid = false;
				return res;
			} else {
				res.max = right.max;
			}
		}
		return res;
	}

	private static class Result {
		public boolean isValid;
		public int min;
		public int max;

		public Result(boolean iv, int i, int a) {
			isValid = iv;
			min = i;
			max = a;
		}
	}
}
