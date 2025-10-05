/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class CountUnivalueSubtree {
    
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Result res = getResult(root);
        return res.count;
    }
    
    public Result getResult(TreeNode root) {
        Result res = new Result(true, root.val, 1);
        
        Result left = new Result(true, root.val, 0);
        if (root.left != null) {
            left = getResult(root.left);
        }
        Result right = new Result(true, root.val, 0);
        if (root.right != null) {
            right = getResult(root.right);
        }
        
        if (!left.isValid || !right.isValid) {
            res.isValid = false;
            res.count = left.count + right.count;
            return res;
        }
        
        if (left.val == root.val && right.val == root.val) {
            res.count += left.count;
            res.count += right.count;
        } else {
            res.isValid = false;
            res.count = left.count + right.count;
        }
        return res;
    }
    
    private static class Result {
        public boolean isValid;
        public int val;
        public int count;
        
        public Result(boolean iv, int v, int c) {
            isValid = iv;
            val = v;
            count = c;
        }
    }// end of Result            
}








