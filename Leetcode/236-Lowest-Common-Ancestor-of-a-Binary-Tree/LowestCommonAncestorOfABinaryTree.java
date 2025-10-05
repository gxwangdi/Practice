/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) 
            return null;
        
        return lca(root, p, q);
    }
    
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        // if (root == null || root.val == p.val || root.val == q.val) 
        if (root == null || root == p || root == q)
            return root;
            
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);  
        if (left!=null && right!=null) 
            return root;
        
        return left==null?right:left;
    }
}




