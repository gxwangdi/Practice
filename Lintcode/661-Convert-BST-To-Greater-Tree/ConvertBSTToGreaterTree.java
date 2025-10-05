

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class ConvertBSTToGreaterTree {
	/**
     * @param root the root of binary tree
     * @return the new root
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        Result res = convertBST(root, 0);
        return res.node;
    }
    
    // Root would never be null.
    private Result convertBST(TreeNode root, int sum) {
        Result res = new Result();
        res.node = root;
        
        if (root.right != null) {
            Result right = convertBST(root.right, sum);
            root.val += right.max;
        } else {
            root.val += sum;
        }
        
        if (root.left != null) {
            Result left = convertBST(root.left, root.val);
            res.max = left.max;
        } else {
            res.max = root.val;
        }
        return res;
    }
    
    private static class Result {
        public TreeNode node;
        public int max;
    }
}
