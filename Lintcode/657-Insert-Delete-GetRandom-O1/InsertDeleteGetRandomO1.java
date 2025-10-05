import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class InsertDeleteGetRandomO1 {
	private Map<Integer, Integer> KVMap;
    private Map<Integer, Integer> VKMap;
    Random random; 
    
    public InsertDeleteGetRandomO1() {
        KVMap = new HashMap<>();
        VKMap = new HashMap<>();
        random = new Random();
    }
    
    // Inserts a value to the set
    // Returns true if the set did not already contain the specified element or false
    public boolean insert(int val) {
        boolean result = !VKMap.containsKey(val);
        if (result) {
            int key = KVMap.size();
            VKMap.put(val, key);
            KVMap.put(key, val);
        }
        return result;
    }
    
    // Removes a value from the set
    // Return true if the set contained the specified element or false
    public boolean remove(int val) {
        boolean result = VKMap.containsKey(val);
        if ( result ) {
            int K1 = VKMap.get(val);
            VKMap.remove(val);
            if (K1 == KVMap.size()-1) {
                KVMap.remove(K1);
            } else {
                int K2 = KVMap.size()-1;
                int V2 = KVMap.get(K2);
                VKMap.put(V2, K1);
                KVMap.put(K1, V2);
                KVMap.remove(K2);
            }
        }
        return result;
    }
    
    // Get a random element from the set
    public int getRandom() {
        int key = random.nextInt(KVMap.size());
        return KVMap.get(key);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */


