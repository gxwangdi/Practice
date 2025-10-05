import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> currLevel = new LinkedList<>();
        Queue<TreeLinkNode> nextLevel = new LinkedList<>();
        Queue<TreeLinkNode> temp;
        
        if (root!=null) {
            currLevel.offer(root);
        }
        
        while (!currLevel.isEmpty()) {
            TreeLinkNode first = null;
            TreeLinkNode last = null;
            while (!currLevel.isEmpty()) {
                first = last;
                last = currLevel.poll();
                if (first!=null) {
                    first.next = last;
                }
                if (last.left != null) {
                    nextLevel.offer(last.left);
                }
                if (last.right != null) {
                    nextLevel.offer(last.right);
                }
            }
            temp = nextLevel;
            nextLevel = currLevel;
            currLevel = temp;
        }
    }
}



