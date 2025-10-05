
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseNodesInKGroup {

	/**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k < 2) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		ListNode n1 = null;
		ListNode n2 = null;
		int count;
		while (cur.next != null) {
			n1 = cur;
			count = k;
			while (cur.next != null && count > 0) {
				cur = cur.next;
				count--;
			}
			if (count > 0) { // end of list
				break;
			}
			n2 = cur;
			cur = reverse(n1, n2);
		}
		return dummy.next;
	}//

	private ListNode reverse(ListNode dummy, ListNode tail) {
		ListNode res = dummy.next;
		ListNode n1 = dummy.next;
		ListNode n2 = n1.next;
		n1.next = tail.next;
		tail.next = null;
		while (n2 != null) {
			ListNode ln = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = ln;
		}
		dummy.next = n1;
		return res;
	}// end of reverse
}
