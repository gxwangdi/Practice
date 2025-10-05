
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapTwoNodesInLinkedList {
	/**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
	public ListNode swapNodes(ListNode head, int v1, int v2) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		ListNode[] n = new ListNode[2];
		int count = 0;
		while (cur.next != null) {
			if (cur.next.val == v1) {
				n[count++] = cur;
			} else if (cur.next.val == v2) {
				n[count++] = cur;
			}
			if (count == 2) {
				break;
			}
			cur = cur.next;
		}
		if (count == 2) {
			ListNode temp = n[0].next;
			n[0].next = n[1].next;
			n[1].next = temp;

			temp = n[0].next.next;
			n[0].next.next = n[1].next.next;
			n[1].next.next = temp;
		}

		return dummy.next;
	}
}
