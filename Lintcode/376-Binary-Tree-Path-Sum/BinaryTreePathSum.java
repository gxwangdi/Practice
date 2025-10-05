import java.util.ArrayList;
import java.util.List;

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

public class BinaryTreePathSum {
	/**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        getPathSum(root, target, res, cur);
        return res;
    }
    
    private void getPathSum(TreeNode node
        , int target, List<List<Integer>> res
        , List<Integer> cur) {
        cur.add(node.val);
        target = target - node.val;
        if (node.left == null && node.right == null) {
            if (target == 0) {
                res.add(cur);
            }
            return;
        } 
        
        if (node.left != null) {
            getPathSum(node.left, target, res
                , new ArrayList<Integer>(cur));
        }
        if (node.right != null) {
            getPathSum(node.right, target, res
                , new ArrayList<Integer>(cur));
        }
    }
}
