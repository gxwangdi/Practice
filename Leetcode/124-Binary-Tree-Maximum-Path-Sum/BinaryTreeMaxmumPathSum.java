/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeMaxmumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        getMaxSum(root, max);
        return max[0];
    }
    
    private int getMaxSum(TreeNode root, int[] max) {
        if (root == null)
            return 0;
        
        int leftSum = getMaxSum(root.left, max);
        int rightSum = getMaxSum(root.right, max);
        int current = Math.max(root.val, root.val+Math.max(leftSum, rightSum));
        max[0] = Math.max(max[0], Math.max(current, root.val + leftSum + rightSum));
        return current;
    }
}