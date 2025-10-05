
//  Definition for ListNode.
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class MergeTwoSortedLists {
	/**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode curRes = dummy;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null || (cur2 != null && cur1.val > cur2.val)) {
                curRes.next = cur2;
                cur2 = cur2.next;
            } else {
                curRes.next = cur1;
                cur1 = cur1.next;
            }
            curRes = curRes.next;
        }
        return dummy.next;
    }
}
