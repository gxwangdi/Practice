import java.util.HashMap;
import java.util.Map;

public class RandomizedSet {

    Map<Integer, Integer> m1; //<V, K>
    Map<Integer, Integer> m2; //<K, V>
    int counter;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        counter = 0;
        m1 = new HashMap<>();
        m2 = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (m1.containsKey(val)) {
            return false;
        }
        m1.put(val, counter);
        m2.put(counter, val);
        counter++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!m1.containsKey(val)) {
            return false;
        }
        int k = m1.get(val);
        m1.remove(val);
        m2.remove(k);
        counter--;
        if (counter == k) { // think of this case !    
            return true;
        }
        int v1 = m2.get(counter);
        m2.remove(counter);
        m2.put(k, v1);
        m1.put(v1, k);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if (counter == 0) {
            return Integer.MIN_VALUE;
        }
        int index = (int)(Math.random()*(counter-1));
        return m2.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
 
 
 
 
 