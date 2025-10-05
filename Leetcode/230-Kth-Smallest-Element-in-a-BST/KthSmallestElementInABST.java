import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestElementInABST {
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        while (n.left != null) {
            stack.push(n);
            n = n.left;
        }
        
        while (k>0 && (n!=null || !stack.empty())) {
            if (n == null) {
                n = stack.pop();
                if (--k == 0) {
                    return n.val;
                }
                n = n.right;
            } else {
                stack.push(n);
                n = n.left;
            }
        }
        return n.val;
    }
    
    /*
    private Result kst(TreeNode node, int k) {
        if (node == null) {
            return new Result(false, 0);
        }
        if (node.left == null && k==1) {
            return new Result(true, node.val);
        }
        Result left = kst(node.left, k);
        if (left.found) {
            return new Result(true, left.val);
        }
        k = k-left.val;
        if (k == 1) {
            return new Result(true, node.val);
        }
        Result right = kst(node.right, k-1);
        if (right.found) {
            return new Result(true, right.val);
        }
        return new Result(false, left.val+right.val+1);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        Result res = kst(root, k);
        if (res.found) {
            return res.val;
        }
        return Integer.MIN_VALUE;
    }
    
    private static class Result {
        public boolean found;
        public int val;
        public Result(boolean f, int v) {
            found = f;
            val = v;
        }
    }
    */
}