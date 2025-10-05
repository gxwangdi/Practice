
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
public class ReverseLinkedListII {
	/**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || n <= m) {
			return head;
		}

		ListNode mDummy = new ListNode(0);
		mDummy.next = head;
		ListNode cur = mDummy;
		for (int i = 0; i + 1 < m; i++) {
			if (cur != null) {
				cur = cur.next;
			}
		}
		ListNode mPrev = cur;
		ListNode n1 = null;
		if (mPrev != null) {
			n1 = mPrev.next;
		}
		ListNode n2 = null;
		if (n1 != null) {
			n2 = n1.next;
		}
		int range = n - m;
		while (range > 0 && n2 != null) {
			ListNode temp = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = temp;
			range--;
		}
		if (mPrev != null) {
			mPrev.next.next = n2;
			mPrev.next = n1;
		}
		return mDummy.next;
	}
}
