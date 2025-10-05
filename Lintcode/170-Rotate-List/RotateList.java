
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RotateList {
	/**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int len = 0;
        while (cur!=null) {
            cur = cur.next;
            len++;
        }
        k = k%len;
        if (k == 0) {
            return head;
        }
        cur = dummy;
        while (k>0) {
            cur = cur.next;
            k--;
        }
        ListNode slow = dummy;
        while (cur.next!=null) {
            cur = cur.next;
            slow = slow.next;
        }
        head = slow.next;
        slow.next = null;
        cur.next = dummy.next;
        return head;
    }
}
