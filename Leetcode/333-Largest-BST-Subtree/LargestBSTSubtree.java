/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Result res = helper(root);
        return res.size;
    }
    
    // node can never be null.
    private Result helper(TreeNode node) {
        Result res = new Result(true, 1, node.val, node.val);
        // boolean isValid = true;
        Result left = null;
        if (node.left!=null) {
            left = helper(node.left);
            if (!left.isValid || left.max > node.val) {
                res.isValid = false;
            } 
        }
        
        Result right = null;
        if (node.right!=null) {
            right = helper(node.right);
            if (!right.isValid || right.min < node.val) {
                res.isValid = false;
            }
        }
        
        if (res.isValid) {
            if (left != null) {
                res.size += left.size;
                res.min = left.min;
            }
            if (right != null) {
                res.size += right.size;
                res.max = right.max;
            }
        } else {
            int size = 1; 
            if (left != null) {
                size = Math.max(size, left.size);
            }
            if (right != null) {
                size = Math.max(size, right.size);
            }
            res.size = size;
        }
        
        return res;
    }
    
    private static class Result {
        boolean isValid;
        int size;
        int min;
        int max;
        public Result(boolean iv, int size, int min, int max) {
            this.isValid = iv;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}




