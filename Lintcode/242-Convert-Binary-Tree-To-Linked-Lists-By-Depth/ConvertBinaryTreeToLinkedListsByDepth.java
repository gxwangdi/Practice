import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ConvertBinaryTreeToLinkedListsByDepth {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> curLevel = new ArrayDeque<>();
        Queue<TreeNode> nextLevel = new ArrayDeque<>();
        curLevel.offer(root);
        while (curLevel.peek() != null) {
            // Start of a level.
            ListNode head = null;
            ListNode cur = null;
            while (curLevel.peek() != null) {
                TreeNode c = curLevel.poll();
                if (head == null) {
                    head = new ListNode(c.val);
                    cur = head;
                } else {
                    cur.next = new ListNode(c.val);
                    cur = cur.next;
                }
                if (c.left != null) {
                    nextLevel.offer(c.left);
                }
                if (c.right != null) {
                    nextLevel.offer(c.right);
                }
            }
            if (head != null) {
                result.add(head);
            }
            curLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
        }
        return result;
    }
}

