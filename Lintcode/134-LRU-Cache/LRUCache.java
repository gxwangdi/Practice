import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private static class Node {
		public int val;
		public int key;
		public Node prev;
		public Node next;

		public Node(int k, int v) {
			key = k;
			val = v;
			prev = next = null;
		}
	}

	private Node head;
	private Node tail;
	private Map<Integer, Node> map;
	private int capacity;

	public LRUCache(int c) {
		head = tail = null;
		map = new HashMap<>();
		if (c > 0) {
			capacity = c;
		} else {
			capacity = 3;
		}
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			removeNode(n);
			setHead(n);
			return n.val;
		} else {
			return -1;
		}
	}

	private void removeNode(Node node) {
		Node cur = node;
		Node prev = cur.prev;
		Node next = cur.next;
		// PAY ATTENTION to the way we handle prev and next!
		if (prev != null) {
			prev.next = next;
		} else {
			head = next;
		}

		if (next != null) {
			next.prev = prev;
		} else {
			tail = prev;
		}
	}

	private void setHead(Node node) {
		node.next = head;
		// Need to clean the state and reset prev.
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		if (tail == null) {
			tail = node;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			n.val = value;
			removeNode(n);
			setHead(n);
		} else {
			Node n = new Node(key, value);
			if (map.size() < capacity) {
				setHead(n);
				map.put(key, n);
			} else {
				map.remove(tail.key);
				// PAY ATTENTION cannot call removeNode(tail);
				tail = tail.prev;
				if (tail != null) {
					tail.next = null;
				}
				setHead(n);
				map.put(key, n);
			}
		}
	}// end of set
}
