import java.util.LinkedList;
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
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) 
            return res;
        String cur = "";
        dfs(root, res, cur);
        return res;
    }
    
    // Make sure node is not null.
    private void dfs(TreeNode node, List<String> list, String cur) {
        if (cur.length() != 0) {
            cur += "->";
        }
        cur += node.val;
        if (node.left == null && node.right == null) {
            list.add(cur);
            return;
        }
        if (node.left!=null) {
            dfs(node.left, list, cur);
        }
        if (node.right!=null) {
            dfs(node.right, list, cur);
        }
    }
}



