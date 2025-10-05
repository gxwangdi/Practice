import java.util.ArrayDeque;
import java.util.Collections;
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
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null)
            return res;
        
        List<Integer> level = new LinkedList<>();
        Deque<TreeNode> current = new ArrayDeque<>();
        current.offer(root);    
        Deque<TreeNode> next = new ArrayDeque<>();   
        while (!current.isEmpty()) {
            TreeNode node = current.poll();
            level.add(node.val);
            
            if (node.left!=null)
                next.offer(node.left);
            if (node.right!=null)
                next.offer(node.right);
            
            if (current.isEmpty()) {
                res.add(level);
                level = new LinkedList<>();
                current = next;
                next = new ArrayDeque<>();
            }
        }
        Collections.reverse(res);
        return res;
    }
}