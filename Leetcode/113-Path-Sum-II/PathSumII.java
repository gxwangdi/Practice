import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pathHelper(root, res, list, sum);
        return res;
    }
    
    private void pathHelper(TreeNode root, List<List<Integer>> res, List<Integer> progress, int sum) {
        sum = sum - root.val;
        progress.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                res.add(progress);
            }
            return;
        }
        if (root.left != null) {
            pathHelper(root.left, res, new ArrayList<>(progress), sum);
        }
        if (root.right != null) {
            pathHelper(root.right, res, new ArrayList<>(progress), sum);
        }
    }// end of pathHelper   
}



