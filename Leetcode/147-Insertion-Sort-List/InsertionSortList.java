/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode temp;
        while (head!=null) {
            temp = head;
            head = head.next;
            temp.next = null;
            ListNode n = dummy;
            while (n.next!=null) {
                if (temp.val < n.next.val) {
                    break;
                }
                n = n.next;
            }
            temp.next = n.next;
            n.next = temp;
        }
        return dummy.next;
    }
}
