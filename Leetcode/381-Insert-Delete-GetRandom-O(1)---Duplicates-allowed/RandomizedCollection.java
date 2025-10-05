import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedCollection {

    Map<Integer, List<Integer>> map;
	List<Integer> list;

	public RandomizedCollection() {
	    map = new HashMap<>();
	    list = new ArrayList<>();
	}

	public boolean insert(int val) {
		boolean exist = false;
		list.add(val);
		if (map.containsKey(val) == false) {
			map.put(val, new ArrayList<Integer>());
			exist = true;
		}
		map.get(val).add(list.size() - 1);
        return exist;
	}

	public boolean remove(int val) {
		if (map.containsKey(val) == false) {
			return false;
		}
		List<Integer> indexes = map.get(val);
		map.remove(val);

        int max = Integer.MIN_VALUE;
        for(Integer index: indexes) {
            max = Math.max(max, index.intValue());
        }

		if (max == list.size() - 1) {
			list.remove(list.size() - 1);
		} else {
			List<Integer> old = map.get(list.get(list.size() - 1));
				
			old.remove(old.indexOf(list.size() - 1));
			old.add(max);

			list.set(max, list.get(list.size() - 1));
			list.remove(list.size() - 1);
		}
		return true;
	}

	public int getRandom() {
		return list.get((new java.util.Random()).nextInt(list.size()));
	}

    /*
    private static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int v) {
            val = v;
        }
    }// end of ListNode

    // private Map<Integer, Integer> VCount;
    private Map<Integer, ListNode> VCount;
    private Map<Integer, Integer> CountV;
    private int count;
    */
    
    /*
    private Map<Integer, Queue<Integer>> map;
    private List<Integer> list;
    */
    
    /** Initialize your data structure here. */
    /*
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    */
    
    
    /*
    public RandomizedCollection() {
        VCount = new HashMap<>();
        CountV = new HashMap<>();
        count = 0;
    }*/
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    /*
    public boolean insert(int val) {
        list.add(val);
        boolean contains = true;
        if (!map.containsKey(val)) {
            map.put(val, new LinkedList<Integer>());
            contains = false;
        }
        map.get(val).offer(list.size()-1);
        return contains;
    }
    */
    
    
    /*
    public boolean insert(int val) {
        boolean res;
        ListNode node = new ListNode(count);
        if (VCount.containsKey(val)) {
            res = false;
            ListNode v = VCount.get(val);
            node.next = v;
            VCount.put(val, node);
        } else {
            res = true;
            VCount.put(val, node);
        }
        CountV.put(count, val);
        count++;
        return res;
    }
    */
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    /*
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Queue<Integer> q = map.get(val);
        int index = q.poll();
        if (q.isEmpty()) {
            map.remove(val);
        }
        if (index != list.size()-1) {
            int lastElement = list.get(list.size()-1);
            Queue<Integer> lastQueue = map.get(lastElement);
            lastQueue.poll();
            lastQueue.offer(index);
            list.set(index, lastElement);// O(1)?
        }
        list.remove(list.size()-1);
        return true;
    }
    */
    
    
    /*
    public boolean remove(int val) {
        boolean res;
        if (VCount.containsKey(val)) {
            res = true;
            ListNode head = VCount.get(val);
            int k = head.val;
            head = head.next;
            if (head == null) {
                VCount.remove(val);
            } else {
                VCount.put(val, head);
            }
            
            count--;
            CountV.remove(k);
            if (count == k) {
                return res;
            }
            int v = CountV.get(count);
            CountV.remove(count);
            CountV.put(k, v);
            ListNode node = VCount.get(v);
            while (node!=null && node.val!=count) {
                node = node.next;
            } 
            if (node!=null) {
                node.val = k;
            }
        } else {
            res = false;
        }
        return res;
    }
    */
    
    /** Get a random element from the collection. */
    /*
    public int getRandom() {
        int index = (int)(Math.random()*(list.size()-1));
        return list.get(index);
    }
    */
    
    /*
    public int getRandom() {
        if (count == 0) { // if it is empty.
            return Integer.MIN_VALUE;
        }
        int index = (int)(Math.random()*(count-1));
        return CountV.get(index);
    }// end of getRandom         
    */
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
 
 
 
 
 
 
 
 
 