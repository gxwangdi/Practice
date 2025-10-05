class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class CopyListWithRandomPointer {
	/**
	 * @param head
	 *            : The head of linked list with a random pointer.
	 * @return: A new head of a deep copy of the list.
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		insertPeerNode(head);
		buildRandomPointers(head);
		RandomListNode peer = separatePeerList(head);
		return peer;
	}

	private RandomListNode separatePeerList(RandomListNode head) {
		RandomListNode cur = head;
		RandomListNode peerHead = null;
		RandomListNode peerCur = null;
		while (cur != null) {
			if (peerHead == null) {
				peerHead = cur.next;
				peerCur = peerHead;
			} else {
				peerCur.next = cur.next;
				peerCur = peerCur.next;
			}
			cur.next = cur.next.next;
			cur = cur.next;
		}
		return peerHead;
	}

	private void buildRandomPointers(RandomListNode head) {
		RandomListNode cur = head;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
	}

	private void insertPeerNode(RandomListNode head) {
		RandomListNode cur = head;
		RandomListNode peer;
		while (cur != null) {
			peer = new RandomListNode(cur.label);
			peer.next = cur.next;
			cur.next = peer;
			cur = peer.next;
		}
	}
}
