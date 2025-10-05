import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class InvertBinaryTree {
    
    /* // Recursive approach
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }*/
    
    // Iterative approach
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                continue;
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            q.offer(node.left);
            q.offer(node.right);
        }
        return root;
    }
}// end of Solution class   



