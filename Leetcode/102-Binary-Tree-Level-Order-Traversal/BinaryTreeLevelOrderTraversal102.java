import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
public class BinaryTreeLevelOrderTraversal102{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        
        Deque<TreeNode> current = new ArrayDeque<>();
        current.offer(root);
        Deque<TreeNode> next = new ArrayDeque<>();
        List<Integer> level = new LinkedList<Integer>();
        while (!current.isEmpty()) {
            TreeNode node = current.poll();
            level.add(node.val);
            
            if (node.left != null)
                next.add(node.left);
            if (node.right !=null)
                next.add(node.right);
            
            if (current.isEmpty()) {
                res.add(level);
                level = new LinkedList<>();
                current = next;
                next = new ArrayDeque<>();
            }
        }
        return res;
    }
}