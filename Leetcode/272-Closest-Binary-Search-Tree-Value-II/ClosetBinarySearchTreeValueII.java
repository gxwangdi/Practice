import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ClosetBinarySearchTreeValueII {
    
    /*
    // Naive approach in README.md 
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
    }
    */
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> succ = new Stack<>();
        Stack<TreeNode> pred = new Stack<>();
        initializePredecessorStack(root, target, pred);
        initializeSuccessorStack(root, target, succ);
        if(!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) {
            // root.val == target.
            getNextPredecessor(pred);
        }
        while (k-- > 0) {
            if (succ.isEmpty()) {
                ret.add(getNextPredecessor(pred));
            } else if (pred.isEmpty()) {
                ret.add(getNextSuccessor(succ));
            } else {
                double succ_diff = Math.abs( (double)succ.peek().val - target);
                double pred_diff = Math.abs( (double)pred.peek().val - target);
                if (succ_diff < pred_diff) {
                    ret.add(getNextSuccessor(succ));
                } else {
                    ret.add(getNextPredecessor(pred));
                }
            }
        }
        return ret;
    }
    
    // Put all successors along the route from root to the node closest to target into succ stack.
    private void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> succ) {
        while (root != null) {
            if (root.val == target) {
                succ.push(root);
                break;
            } else if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }// end of root loop
    }
    
    // Put all predecessors along the route from root to the node closest to target into pre stack.
    private void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> pre) {
        while (root != null) {
            if (root.val == target) {
                pre.push(root);
                break;
            } else if (root.val < target) {
                pre.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }// end of root loop
    }
    
    // Get the value of the peek node, but prepare the stack peek as the right next node in in-order sequence.    
    private int getNextSuccessor(Stack<TreeNode> suc) {
        TreeNode cur = suc.pop();
        int ret = cur.val;
        cur = cur.right;
        while (cur != null) {
            // ret = cur.val;
            suc.push(cur);
            cur = cur.left;
        }
        return ret;
    }
    
    // Get the value of the peek node, but prepare the stack peek as the right previous node in in-order sequence. 
    private int getNextPredecessor(Stack<TreeNode> pre) {
        TreeNode cur = pre.pop();
        int ret = cur.val;
        cur = cur.left;
        while (cur != null) {
            // ret = cur.val;
            pre.push(cur);
            cur = cur.right;
        }
        return ret;
    }// end of getNextPredecessor   
}





