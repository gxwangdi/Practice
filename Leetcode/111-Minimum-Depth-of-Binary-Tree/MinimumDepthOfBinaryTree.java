/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinimumDepthOfBinaryTree {
    
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }
    
    private int getMin(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return Math.min(getMin(node.left), getMin(node.right)) + 1;
    }
    
    /*
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        int left = minHeight(root.left);
        int right = minHeight(root.right);
        if (root.left == null) {
            left = Integer.MAX_VALUE;
        }
        if (root.right == null) {
            right = Integer.MAX_VALUE;
        }
        return Math.min(left, right)+1;
    }
    
    private int minHeight(TreeNode node) {
        if (node == null) 
            return 0;
        
        int left = minHeight(node.left);
        int right = minHeight(node.right);    
        if (left == 0 && right == 0) {
            return 1;
        }
        if (left == 0)
            left = Integer.MAX_VALUE;
        if (right == 0)
            right = Integer.MAX_VALUE;
        return Math.min(left, right)+1;
    }*/
}




