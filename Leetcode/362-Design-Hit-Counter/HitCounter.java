import java.util.HashMap;
import java.util.Map;

public class HitCounter {

    Map<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        // map = new ConcurrentHashMap<>();
        map = new HashMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        // synchronized (map) {
        //     if (map.containsKey(timestamp)) {
        //     map.put(timestamp, map.get(timestamp)+1);
        // } else {
        //     map.put(timestamp, 1);
        // }
        // }
        if (map.containsKey(timestamp)) {
            map.put(timestamp, map.get(timestamp)+1);
        } else {
            map.put(timestamp, 1);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int sum = 0;
        // synchronized (map) {
        //     for (Integer key : map.keySet()) {
        //     if (timestamp - key >= 300) {
        //         map.remove(key);
        //     } else {
        //         sum += map.get(key);
        //     }
        // }
        // }
        for (Integer key : map.keySet()) {
            // if (timestamp - key >= 300) {
            //     map.remove(key);
            // } else {
            //     sum += map.get(key);
            // }
            if (timestamp - key < 300) {
                sum += map.get(key);
            }
        }
        return sum;
    }// 
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
 
 
 
 
 