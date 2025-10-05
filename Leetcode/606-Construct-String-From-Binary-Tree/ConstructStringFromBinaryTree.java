

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        var left = tree2str(root.left);
        var right = tree2str(root.right);
        if (right.length() >0) {
            sb.append('(').append(left).append(')').append('(').append(right).append(')');
            return sb.toString();
        }
        if (left.length() >0) {
            sb.append('(').append(left).append(')');
        }
        return sb.toString();
    }
}
