/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    
    public boolean hasPathSum(TreeNode root, int sum) {
	    if (root == null)
		    return false;
	    if (root.val == sum && (root.left == null && root.right == null))
		    return true;
 
	    return hasPathSum(root.left, sum - root.val)
			|| hasPathSum(root.right, sum - root.val);
    }
    
    /*
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) 
            return false;
        
        return dfs(root, sum, 0);
    }
    
    private boolean dfs(TreeNode node, int sum, int cur) {
        cur += node.val;
        if (node.left == null && node.right == null) 
            return cur == sum;
        
        boolean result = false;
        if (node.left!=null)
            result = result || dfs(node.left, sum, cur);
        if (node.right!=null)
            result = result || dfs(node.right, sum, cur);
        return result;
    }*/
    
}