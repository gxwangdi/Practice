
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {
	/**
     * @param head a ListNode
     * @return a ListNode
     */
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			ListNode temp = cur.next.next.next;
			cur.next.next.next = cur.next;
			cur.next = cur.next.next;
			cur.next.next.next = temp;

			cur = cur.next.next;
		}
		return dummy.next;
	}
}
