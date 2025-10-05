/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLongestConsecutiveSequence {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[1]; // value 0.
        getMaxLength(max, 0, root);
        return max[0];
    }
    private void getMaxLength(int[] max, int cur, TreeNode root) {
        cur++;
        if (cur > max[0]) {
            max[0] = cur;
        }
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                getMaxLength(max, cur, root.left);
            } else {
                getMaxLength(max, 0, root.left);
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                getMaxLength(max, cur, root.right);
            } else {
                getMaxLength(max, 0, root.right);
            }
        }
    }
}

