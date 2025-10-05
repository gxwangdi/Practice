/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        ListNode cur = head;
        
        ListNode leftDummy = new ListNode(0);
        ListNode leftCur = leftDummy;
        
        ListNode rightDummy = new ListNode(0);
        ListNode rightCur = rightDummy;
        
        while (cur!=null) {
            if (cur.val < x) {
                leftCur.next = cur;
                cur = cur.next;
                leftCur = leftCur.next;
                leftCur.next = null;
            } else {
                rightCur.next = cur;
                cur = cur.next;
                rightCur = rightCur.next;
                rightCur.next = null;
            }
        }
        leftCur.next = rightDummy.next;
        return leftDummy.next;
    }
}




