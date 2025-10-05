

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
class MergeNodesInBetweenZero {
    public ListNode mergeNodes(ListNode head) {
        var dummy = new ListNode();
        var c = dummy;
        var cur = head;
        var sum = 0;
        while (cur.next !=null) {
            if (cur.next.val == 0) {
                c.next = new ListNode(sum);
                sum = 0;
                c = c.next;
                cur = cur.next;
                continue;
            }
            sum += cur.next.val;
            cur = cur.next;
        }

        return dummy.next;
    }
}
