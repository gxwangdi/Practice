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
class Twosumivinputisabst {
    public boolean findTarget(TreeNode root, int k) {
        var set = new HashSet<Integer>();
        return preOrder(root, k, set);
    }

    private boolean preOrder(TreeNode node, int k, Set<Integer> set) {
        if (node == null) {
            return false;
        }
        if (set.contains(node.val)) {
            return true;
        }
        set.add(k-node.val);
        return preOrder(node.left, k, set) || preOrder(node.right, k, set);
    }
}
