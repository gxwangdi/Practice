import java.util.HashMap;
import java.util.Map;


public class TwoSumDataStructureDesign {
private Map<Integer, Integer> map = new HashMap<>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) {
	        map.put(number, map.get(number)+1);
	    } else {
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        int i = entry.getKey();
	        int j = value - i;
	        if (i == j && entry.getValue()>1 || i!=j && map.containsKey(j)) {
	            return true;
	        }
	    }
	    return false;
	}
	
    
    //TODO: debug bidirectional linked list approach. 
    // private BiLinkedListNode head;
    // private BiLinkedListNode tail;   
    
    // Add the number to an internal data structure.
    // public void add(int number) {
    //     // Insertion sort
    //     if (head == null) { // no element
    //         head = new BiLinkedListNode(number, null, null);
    //         tail = head;
    //         return;
    //     }
    //     if (head == tail) { // only one element
    //         tail = new BiLinkedListNode(number, head, null);
    //         head.next = tail;
    //         return;
    //     }
    //     BiLinkedListNode node = head;
    //     while (node != null && number > node.val) {
    //         node = node.next;
    //     }
    //     if (node == head) { // smaller than all
    //         node = new BiLinkedListNode(number, null, head);
    //         head.prev = node;
    //         head = head.prev;
    //     }
    //     if (node == null) { // bigger than all
    //         node = new BiLinkedListNode(number, tail, null);
    //         tail.next = node;
    //         tail = tail.next;
    //         return;
    //     } 
    //     // in the middle
    //     BiLinkedListNode cur = node;
    //     node = new BiLinkedListNode(number, cur.prev, cur);
    //     cur.prev.next = node;
    //     cur.prev = node;
    // }

    // // Find if there exists any pair of numbers which sum is equal to the value.
    // public boolean find(int value) {
    //     if (head == tail) {
    //         return false;
    //     }
    //     BiLinkedListNode left = head;
    //     BiLinkedListNode right = tail;
    //     while (left != right) {
    //         int sum = left.val + right.val;
    //         if (sum == value) {
    //             return true;
    //         }
    //         if (sum > value) {
    //             right = right.prev;
    //             continue;
    //         }
    //         left = left.next;
    //     }
    //     return false;
    // }
    
    // private static class BiLinkedListNode {
    //     public int val;
    //     public BiLinkedListNode prev;
    //     public BiLinkedListNode next;
        
    //     public BiLinkedListNode(int v, BiLinkedListNode p, BiLinkedListNode n) {
    //         val = v;
    //         prev = p;
    //         next = n;
    //     }
    // }
}

//Your TwoSum object will be instantiated and called as such:
//TwoSum twoSum = new TwoSum();
//twoSum.add(number);
//twoSum.find(value);  


