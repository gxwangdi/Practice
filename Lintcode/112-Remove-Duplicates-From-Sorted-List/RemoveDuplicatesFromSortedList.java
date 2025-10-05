
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
public class RemoveDuplicatesFromSortedList {
	/**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}
}
