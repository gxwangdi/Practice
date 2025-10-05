/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class PartitionList {
	/**
	 * @param head
	 *            : The first node of linked list.
	 * @param x
	 *            : an integer
	 * @return: a ListNode
	 */
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy1 = new ListNode(0);
		ListNode cur1 = dummy1;
		ListNode dummy2 = new ListNode(0);
		ListNode cur2 = dummy2;
		while (head != null) {
			if (head.val < x) {
				cur1.next = head;
				cur1 = cur1.next;
			} else {
				cur2.next = head;
				cur2 = cur2.next;
			}
			head = head.next;
		}
		cur1.next = dummy2.next;
		cur2.next = null;
		return dummy1.next;
	}
}
