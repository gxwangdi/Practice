/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int len = getLength(head);
        k = k%len;
        if (k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        while (k>0) {
            fast = fast.next;
            k--;
        }
        ListNode slow = dummy;
        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        return dummy.next;
    }
    
    private int getLength(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur!=null) {
            cur = cur.next;
            len++;
        }
        return len;
    }
}




