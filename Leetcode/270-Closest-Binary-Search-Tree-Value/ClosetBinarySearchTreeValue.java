/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class ClosetBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        double minDiff = Double.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        TreeNode cur = root;
        while (cur!=null) {
            double diff = Math.abs(target - cur.val);
            if (diff < minDiff) {
                minDiff = diff;
                res = cur.val;
            }
            if (target > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return res;
    }// end of closestValue
}




