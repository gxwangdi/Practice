
public class MinimumDepthOfBinaryTree {
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null) {
            min = Math.min(min, minDepth(root.left));
        }
        if (root.right != null) {
            min = Math.min(min, minDepth(root.right));
        }
        return min + 1;
    }
}
