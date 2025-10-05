/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;

        ListNode o = head;
        ListNode e = head.next;
        ListNode eHead = head.next;
        while (e!=null && e.next!=null) {
            o.next = e.next;
            e.next = e.next.next;
            o = o.next;
            e = e.next;
        }
        o.next = eHead;
        return head;
    }// end of oddEvenList
}
