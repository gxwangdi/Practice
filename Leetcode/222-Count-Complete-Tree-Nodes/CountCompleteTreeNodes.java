/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountCompleteTreeNodes {
    
    /*
    // recursive manner,  TLE     
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + 1 + countNodes(root.right);
    }
    */
    
    private int height(TreeNode node) {
        return node == null? -1 : 1+height(node.left);
    }
    
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0? 0 : 
            height(root.right) == h-1? 
                (1<<h) + countNodes(root.right) : 
                (1<<h-1) + countNodes(root.left);
    }
}




