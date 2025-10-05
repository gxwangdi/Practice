
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class AddTwoNumbersII {
	/**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
	public ListNode addLists2(ListNode l1, ListNode l2) {
		l1 = reverse(l1);
		l2 = reverse(l2);

		return reverse(addList(l1, l2));
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode n1 = head;
		ListNode n2 = head.next;
		n1.next = null;
		while (n2 != null) {
			ListNode temp = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = temp;
		}
		return n1;
	}// end of reverse

	private ListNode addList(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			cur = cur.next;
		}
		if (carry > 0) {
			cur.next = new ListNode(carry);
			cur = cur.next;
		}
		return dummy.next;
	}
}
