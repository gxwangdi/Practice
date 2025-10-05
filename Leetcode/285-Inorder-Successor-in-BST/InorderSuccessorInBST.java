/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if ( root == null || p==null ) {
            return null;
        }
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.val == p.val) {
                break;
            } else if (cur.val < p.val) {
                cur = cur.right;
            } else { // cur.val > p.val
                prev = cur;
                cur = cur.left;
            }
        }
        if (cur == null) {
            return null;
        }
        if (cur.right == null) {
            return prev;
        }
        cur = cur.right;
        while (cur.left!=null) {
            cur = cur.left;
        }
        return cur;
    }
}




