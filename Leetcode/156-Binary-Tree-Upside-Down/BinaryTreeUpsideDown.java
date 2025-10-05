/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeUpsideDown {
    
    
    /*
    // Iterative approach   
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode node = root; 
        TreeNode parent = null, right = null;
        while (node != null) {
            TreeNode left = node.left;
            node.left = right;
            right = node.right;
            node.right = parent;
            parent = node;
            node = left;
        }
        return parent;      
    }// end of upsideDownBinaryTree
    */
    
    
    // Recursive approach.    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        TreeNode parent = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode res = upsideDownBinaryTree(left);
        left.left = right;
        left.right = parent;
        parent.left = parent.right = null;
        // Take care of the children state, it would probably introduce a loop and cause MLE. 
        return res;
    }// end of upsideDownBinaryTree 
}





