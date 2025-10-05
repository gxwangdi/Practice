
//Definition of TreeNode:
class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}


public class InsertNodeInABinarySearchTree {
	/**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (node == null) {
            return root;
        }
        if (root == null) {
            return node;
        }
        if (root.val == node.val) {
            TreeNode left = root.left;
            root.left = node;
            node.left = left;
            return root;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}
