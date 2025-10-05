
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

public class InsertionSortList {
	/**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode cur = dummy;
		ListNode temp;
		while (head != null) {
			temp = head;
			head = head.next;
			temp.next = null;
			ListNode n = dummy;
			while (n.next != null) {
				if (temp.val < n.next.val) {
					break;
				}
				n = n.next;
			}
			temp.next = n.next;
			n.next = temp;
		}
		return dummy.next;
	}
}
