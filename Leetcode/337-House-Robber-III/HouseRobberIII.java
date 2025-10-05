/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] max = dfs(root);
        
        return Math.max(max[0], max[1]);
    }
    
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0,0};
        }
        
        int[] max = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        max[0] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        max[1] = left[0] + right[0] + root.val;
        return max;
    }
}




