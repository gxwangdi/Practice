
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
public class ReversedLinkedList {
	/**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
	public ListNode reverse(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode n1 = head;
		ListNode n2 = head.next;
		while (n2 != null) {
			ListNode temp = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = temp;
		}
		head.next = null;
		return n1;
	}
}
