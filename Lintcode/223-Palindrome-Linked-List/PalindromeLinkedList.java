
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
	/**
     * @param head a ListNode
     * @return a boolean
     */
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode n1 = slow.next; // head of second half.
		ListNode n2 = n1.next;
		n1.next = null;
		while (n2 != null) {
			fast = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = fast;
		}
		slow = head;
		fast = n1;
		while (fast != null && slow != null) {
			if (fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		if (fast != null) {
			return false;
		}
		return true;
	}
}
