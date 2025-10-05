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
public class BinaryTreeInorderTraversal {
    
    // Morris Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur!=null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                // find predecessor 
                prev = cur.left;
                while (prev.right!=null && prev.right!=cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
    
    
    
    /*
    // An awesome way to implement the iteration, so that preorder/inorder/postorder has the same implementation complexity. 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, false)); 
        TreeNode temp = null;
        boolean visited;
        while (!stack.empty()) {
            temp = stack.peek().node;
            visited = stack.peek().isVisited;
            stack.pop();
            if (temp == null) {
                continue;
            }
            if (visited) {
                res.add(temp.val);
            } else {
                stack.push(new Pair(temp.right, false));
                stack.push(new Pair(temp, true));
                stack.push(new Pair(temp.left, false));
            }
        }
        return res;
    }
    
    private static class Pair {
        public TreeNode node;
        public boolean isVisited;
        public Pair(TreeNode tn, boolean visit) {
            node = tn;
            isVisited = visit;
        }
    }
    */
    
    
    /* // Iterative approach   
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.empty()) {
            while (p!=null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.empty()) {
                p = stack.peek();
                res.add(p.val);
                stack.pop();
                p = p.right;
            }
        }
        return res;
    }*/ 
    
    
    /* // Recursive approach.  
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
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


