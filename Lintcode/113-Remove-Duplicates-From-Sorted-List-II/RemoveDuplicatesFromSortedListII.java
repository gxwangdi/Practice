
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDuplicatesFromSortedListII {
	/**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		boolean isDuplicate = false;
		while (cur != null && cur.next != null) {
			if (cur.next.next != null && cur.next.val == cur.next.next.val) {
				isDuplicate = true;
				cur.next.next = cur.next.next.next;
			} else {
				if (isDuplicate) {
					isDuplicate = false;
					cur.next = cur.next.next;
				} else {
					cur = cur.next;
				}
			}
		}
		return dummy.next;
	}
}
