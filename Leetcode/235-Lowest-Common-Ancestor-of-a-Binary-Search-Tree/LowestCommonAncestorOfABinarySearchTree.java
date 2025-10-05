/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(
        TreeNode root
        , TreeNode p
        , TreeNode q) {
        if ( root == null || p == null || q == null)
            return null;
        
        if (root.val == p.val || root.val == q.val) 
            return root;
            
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left!=null && right!=null) {
            return root;
        }
        
        if (left == null && right == null) {
            return null;
        }
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }// end of lowestCommonAncestor       
}