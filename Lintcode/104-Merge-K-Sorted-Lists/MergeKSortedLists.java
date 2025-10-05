import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


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
public class MergeKSortedLists {
	/**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
	// Heap approach.
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
				lists.size(), listComparator);
		for (ListNode n : lists) {
			while (n != null) {
				heap.offer(n);
				n = n.next;
			}
		}

		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (!heap.isEmpty()) {
			ListNode node = heap.poll();
			cur.next = node;
			cur = cur.next;
		}
		cur.next = null;
		return dummy.next;
	}

	private Comparator<ListNode> listComparator = new Comparator<ListNode>() {
		public int compare(ListNode n1, ListNode n2) {
			if (n1 == null) {
				return 1;
			}
			if (n2 == null) {
				return -1;
			}
			return n1.val - n2.val;
		}
	};
}
