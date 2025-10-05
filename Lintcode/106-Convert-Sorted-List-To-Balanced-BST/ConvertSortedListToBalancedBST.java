
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
public class ConvertSortedListToBalancedBST {
	/**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        TreeNode root = null;
        if (head == null) {
            return root;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        ListNode cur = head;
        if (cur == slow) {
            root.left = null;
            return root;
        }
        while (cur.next!=slow) {
            cur = cur.next;
        }
        cur.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
