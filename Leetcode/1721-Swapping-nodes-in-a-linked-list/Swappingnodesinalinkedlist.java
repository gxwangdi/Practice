

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
class Swappingnodesinalinkedlist {
    public ListNode swapNodes(ListNode head, int k) {
        var dummy = new ListNode();
        dummy.next = head;
        var p2 = dummy;
        var counter = k;
        while(--counter>0) {
            p2 = p2.next;
        }
        var p = p2;
        p2 = p2.next;
        var p1 = dummy;
        while (p2.next != null) {
            p1= p1.next;
            p2= p2.next;
        }
        var temp1 = p.next;
        var temp2 = p1.next;
        p.next = temp2;
        p1.next = temp1;
        temp1 = temp1.next;
        temp2 = temp2.next;
        p1.next.next = temp2;
        p.next.next = temp1;
        return dummy.next;
    }
}
