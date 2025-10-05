

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
class MaxTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        // find the middle of the list
        var p1= head;
        var p2= head;
        while (p2!=null && p2.next!=null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // reverse the second half
        p2 = p1.next;
        p1.next = null;
        while (p2!=null) {
            var temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        // add one by one.
        p2 = head;
        var max = 0;
        while (p1!=null) {
            var temp = p1.val + p2.val;
            max = Math.max(max, temp);
            p1 = p1.next;
            p2 = p2.next;
        }
        return max;
    }
}
