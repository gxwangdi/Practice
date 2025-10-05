import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> currLevel = new LinkedList<>();
        currLevel.offer(root);
        Queue<TreeNode> nextLevel = new LinkedList<>();
        Queue<TreeNode> temp;
        while (!currLevel.isEmpty()) {
            boolean isFirst = true;
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.poll();
                if (isFirst) {
                    res.add(node.val);
                    isFirst = false;
                }
                if (node.right != null) {
                    nextLevel.offer(node.right);
                }
                if (node.left != null) {
                    nextLevel.offer(node.left);
                }
            }
            temp = nextLevel;
            nextLevel = currLevel;
            currLevel = temp;
        }
        return res;
    }
}




