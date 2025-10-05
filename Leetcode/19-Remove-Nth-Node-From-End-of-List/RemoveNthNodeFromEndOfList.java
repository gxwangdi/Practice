/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n<0)
            return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode h = dummy;
        ListNode target = head;
        ListNode tail = head;
        for (int i=0; i<n; i++) {
            tail = tail.next;
        }
        while (tail!=null) {
            tail = tail.next;
            target = target.next;
            h = h.next;
        }
        h.next = target.next;
        return dummy.next;
    }
}