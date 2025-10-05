
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class DeleteTheMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        var dummy = new ListNode();
        dummy.next = head;
        var p1 = dummy;
        var p2 = head;
        while (p2!=null && p2.next!=null) {
            p2 = p2.next.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return dummy.next;
    }
}
