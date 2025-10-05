import java.util.ArrayList;
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

public class BinaryTreeInOrderTraversal {
	/**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
     
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, false));
        TreeNode node;
        boolean visited;
        while (!stack.empty()) {
            node = stack.peek().node;
            visited = stack.peek().visited;
            stack.pop();
            if (node == null) {
                continue;
            }
            if (visited) {
                res.add(node.val);
            } else {
                stack.push(new Pair(node.right, false));
                stack.push(new Pair(node, true));
                stack.push(new Pair(node.left, false));
            }
        }
        return res;
    }
    
    private static class Pair {
        public TreeNode node;
        public boolean visited;
        public Pair(TreeNode tn, boolean v) {
            node = tn;
            visited = v;
        }
    }
     
     
    /* // iterative manner.
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.empty()) {
            while (p!=null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.empty()) {
                p = stack.pop();
                res.add(p.val);
                stack.push(p.right);
            }
        }
        return res;
    }*/
    
    /* // recursive manner.
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }*/
}
