
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
public class RemoveNodeInBinarySearchTree {
	/**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
	public TreeNode removeNode(TreeNode root, int value) {
		if (root == null) {
			return root;
		}
		if (value > root.val) {
			root.right = removeNode(root.right, value);
			return root;
		}
		if (value < root.val) {
			root.left = removeNode(root.left, value);
			return root;
		}
		// value == root.val
		if (root.left == null && root.right == null) {
			return null;
		}
		if (root.left != null) {
			TreeNode node = root.left;
			while (node.right != null) {
				node = node.right;
			}
			node.right = root.right;
			return root.left;
		} else {
			return root.right;
		}
	}
}
