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

public class BinaryTreePaths {
	/**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        getPath(root, res, sb);
        return res;
    }
    
    private void getPath(TreeNode node, List<String> res, StringBuilder progress) {
        if (node.left == null && node.right == null) {
            res.add(progress.toString());
            return;
        }
        
        if (node.left != null) {
            StringBuilder sb = new StringBuilder(progress);
            sb.append("->");
            sb.append(node.left.val);
            getPath(node.left, res, sb);
        }
        
        if (node.right != null) {
            StringBuilder sb = new StringBuilder(progress);
            sb.append("->");
            sb.append(node.right.val);
            getPath(node.right, res, sb);
        }
    }
}
