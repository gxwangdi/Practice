
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
public class RemoveNthNodeFromEndOfList {
	/**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
	ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n < 1) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		while (fast != null && n >= 0) {
			fast = fast.next;
			n--;
		}
		if (fast == null && n >= 0) {
			return head;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}
