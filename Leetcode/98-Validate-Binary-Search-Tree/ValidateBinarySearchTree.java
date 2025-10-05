/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree {
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root).isValid;
    }
    
    // Node can never be null! 
    private Result isValid(TreeNode node) {
        Result res = new Result(true, node.val, node.val);
        Result child;
        if (node.left != null) {
            child = isValid(node.left);
            if ( !child.isValid ) {
                res.isValid = false;
                return res;
            }
            if ( child.max >= node.val) {
                res.isValid = false;
                return res;
            } else {
                res.min = child.min;
            }
        }
        if (node.right != null) {
            child = isValid(node.right);
            if ( !child.isValid ) {
                res.isValid = false;
                return res;
            }
            if ( child.min <= node.val) {
                res.isValid = false;
                return res;
            } else {
                res.max = child.max;
            }
        }
        return res;
    }
    
    private static class Result {
        public boolean isValid;
        public int max;
        public int min;
        public Result(boolean iv, int ma, int mi) {
            isValid = iv;
            max = ma;
            min = mi;
        }
    }// end of Result       
}





