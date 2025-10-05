
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

public class BalancedBinaryTree {
	/**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    private int INVALID_HEIGHT = -1;
    public boolean isBalanced(TreeNode root) {
        // write your code here
        int level = getLevel(root);
        return level != INVALID_HEIGHT;
    }
    
    private int getLevel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = getLevel(node.left);
        if (left == INVALID_HEIGHT) {
            return INVALID_HEIGHT;
        }
        int right = getLevel(node.right);
        if (right == INVALID_HEIGHT) {
            return INVALID_HEIGHT;
        }
        if (Math.abs(left - right) >1) {
            return INVALID_HEIGHT;
        }
        return Math.max(left, right)+1;
    }
}
