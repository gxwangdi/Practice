import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    private static class Node {
        public int key;
        public int val;
        public Node next;
        public Node prev;
        public Node(int k, int v) {
            key = k;
            val = v;
            next = null;
            prev = null;
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
            Node node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    private void removeNode(Node n) {
        Node cur = n;
        Node prev = n.prev;
        Node next = n.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        
        if (next!=null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
    }
    
    private void setHead(Node n) {
        n.next = head;
        n.prev = null;
        if (head!=null) {
            head.prev = n;
        }
        head = n;
        if (tail == null) {
            tail = n;
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




