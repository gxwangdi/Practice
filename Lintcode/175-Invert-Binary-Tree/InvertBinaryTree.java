
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

public class InvertBinaryTree {
	/**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
     // Recursive approach
    public void invertBinaryTree(TreeNode root) {
        invert(root);
    }
    
    private TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = invert(root.left);
        root.left = invert(temp);
        return root;
    }
}



