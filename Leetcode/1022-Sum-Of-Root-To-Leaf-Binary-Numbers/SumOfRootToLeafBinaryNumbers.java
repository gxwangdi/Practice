

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
class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        var sum = new int[1];
        if (root == null) {
            return sum[0];
        }
        helper(root, 0, sum);
        return sum[0];
    }

    private void helper(TreeNode node, int pro, int[] sum) {
        pro = pro*2 + node.val;
        if (node.left == null && node.right == null) {
            sum[0] += pro;
            return;
        }
        if (node.left != null) {
            helper(node.left, pro, sum);
        }
        if (node.right != null) {
            helper(node.right, pro, sum);
        }
    }
}
