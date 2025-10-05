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
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right!=null && prev.right!=cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    res.add(cur.val);
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    /*
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
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
                stack.push(new Pair(node.left, false));
                stack.push(new Pair(node, true));
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
    */


    /* // iterative manner
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node!=null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        return res;
    }*/


    /* // recursive manner
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }*/
}
