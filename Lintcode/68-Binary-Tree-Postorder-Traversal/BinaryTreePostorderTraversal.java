import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class BinaryTreePostorderTraversal {
	/**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
     
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<PairNode> stack = new Stack<>();
        TreeNode node = root;
        boolean isFirst;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(new PairNode(node, true));
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.peek().node;
                isFirst = stack.peek().isFirst;
                stack.pop();
                if (isFirst) {
                    stack.push(new PairNode(node, false));
                    node = node.right;
                } else {
                    res.add(node.val);
                    node = null;
                }
            }
        }
        return res;
    }
    
    private static class PairNode {
        public TreeNode node;
        public boolean isFirst;
        public PairNode(TreeNode tn, boolean f) {
            node = tn;
            isFirst = f;
        }
    }
     
     
    /* // Recursive manner
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
    
    private void postorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
    }*/
}
