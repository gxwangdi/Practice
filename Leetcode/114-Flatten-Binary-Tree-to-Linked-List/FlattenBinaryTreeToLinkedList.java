/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreeToLinkedList {
    
    // Space O(1) solutin.
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        buildLinkedList(root);
    }
    
    private Result buildLinkedList(TreeNode node) {
        Result res = new Result(node, node);
        if (node == null) {
            return res;
        }
        
        Result left = null;
        if (node.left != null) {
            left = buildLinkedList(node.left);
        }
        node.left = null;
        
        Result right = null;
        if (node.right != null) {
            right = buildLinkedList(node.right);
        }
        
        if (left != null) {
            res.tail.right = left.head;
            res.tail = left.tail;
        }
        if (right != null) {
            res.tail.right = right.head;
            res.tail = right.tail;
        }
        return res;
    }
    
    private static class Result {
        public TreeNode head;
        public TreeNode tail;
        public Result (TreeNode h, TreeNode t) {
            head = h;
            tail = t;
        }
    }// end of class Result  
}




