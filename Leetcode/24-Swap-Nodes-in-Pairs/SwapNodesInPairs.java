/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode A = head;
        dummy.next = A;
        head = A.next;
        ListNode B;
        while (A!=null) {
            B = A.next;
            if (B == null)
                break;
            
            A.next = B.next;
            B.next = A;
            dummy.next = B;
            dummy = A;
            A = A.next;
        }
        return head;
    }
}