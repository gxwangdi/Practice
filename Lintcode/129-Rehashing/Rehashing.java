
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
public class Rehashing {
	/**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
	public ListNode[] rehashing(ListNode[] hashTable) {

		if (hashTable == null) {
			return null;
		}
		int size = hashTable.length * 2;
		ListNode[] res = new ListNode[size];
		if (size == 0) {
			return res;
		}

		for (ListNode ln : hashTable) {
			if (ln == null) {
				continue;
			}
			while (ln != null) {
				int index = ln.val % size;
				if (index < 0) {
					index += size;
				}
				ListNode node = res[index];
				if (node == null) {
					res[index] = new ListNode(ln.val);
					ln = ln.next;
					continue;
				}
				while (node.next != null) {
					node = node.next;
				}
				node.next = new ListNode(ln.val);

				ln = ln.next;
			}
		}
		return res;
	}
}
