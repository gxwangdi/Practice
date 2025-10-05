/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode cur = head;
        ListNode nextVal;
        while (cur!=null && cur.next!=null) {
            nextVal = cur.next;
            while (nextVal!=null && nextVal.val == cur.val) {
                nextVal = nextVal.next;
            }
            cur.next = nextVal;
            cur = cur.next;
        }
        return head;
    }
}


