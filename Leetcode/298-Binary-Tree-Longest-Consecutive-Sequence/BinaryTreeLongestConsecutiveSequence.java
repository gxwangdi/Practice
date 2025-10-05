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
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[1];
        getLength(root, max);
        return max[0];
    }
    
    private Result getLength(TreeNode node, int[] max) {
        Result res = new Result(1, node.val);
        if (node.left == null && node.right == null) {
            max[0] = Math.max(max[0], 1);
            return res;
        }
        
        Result left = new Result(0, node.val);
        if (node.left!=null) {
            left = getLength(node.left, max);   
            if (node.val == left.val-1) {
                res.count = Math.max(res.count, left.count+1);
            }
        }
        
        Result right = new Result(0, node.val);
        if (node.right!=null) {
            right = getLength(node.right, max);
            if (node.val == right.val -1) {
                res.count = Math.max(res.count, right.count+1);
            }
        }
        
        max[0] = Math.max(max[0], res.count);
        return res;
    }
    
    private static class Result{
        public int count;
        public int val;
        public Result(int c, int v) {
            count = c;
            val = v;
        }
    }// end of Result class         
}




