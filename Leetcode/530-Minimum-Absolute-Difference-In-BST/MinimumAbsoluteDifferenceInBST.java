

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
class MinimumAbsoluteDifferenceInBST {
    private int min = Integer.MAX_VALUE;
    private int prev = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min; //returning min value
    }

    private void inOrder(TreeNode root){
        if(root == null) {
            return;
        }

        inOrder(root.left);

        min = Math.min(min, Math.abs(prev - root.val)); //min value
        prev = root.val; //previous min value

        inOrder(root.right);
    }
}
