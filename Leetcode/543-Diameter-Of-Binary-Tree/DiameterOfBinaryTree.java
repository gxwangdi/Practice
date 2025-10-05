/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class DiameterOfBinaryTree {
  public int diameterOfBinaryTree(TreeNode root) {
        int[] res = getDiameter(root);
        return res[0];
    }

    /**
     * @return [0] for round, [1] for edge.
     */
    private int[] getDiameter(TreeNode node) {
        int[] res = new int[2];
        if (node == null) {
            return res;
        }
        int[] left = getDiameter(node.left);
        int[] right = getDiameter(node.right);
        res[0] = Math.max(left[1]+right[1], Math.max(left[0], right[0]));
        res[1] = Math.max(left[1], right[1])+1;
        return res;
    }
}
