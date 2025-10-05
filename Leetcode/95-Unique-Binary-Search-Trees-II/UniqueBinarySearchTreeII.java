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
public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        if (n<1) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (left > right) {
            res.add(null);
            return res;
        }
        if (left == right) {
            TreeNode node = new TreeNode(left);
            res.add(node);
            return res;
        }
        for (int i=left; i<=right; i++) {
            List<TreeNode> leftNodes = generateTrees(left, i-1);
            List<TreeNode> rightNodes = generateTrees(i+1, right);
            for (int j=0; j<leftNodes.size(); j++) {
                for (int k=0; k<rightNodes.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNodes.get(j);
                    root.right = rightNodes.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}




