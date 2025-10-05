import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
    
    private long getID(long i, long w) {
        return i<0?(i+1)/w - 1:i/w;
    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        long w = (long)t + 1;    
        for (int i=0; i<nums.length; i++) {
            long m = getID(nums[i], w);
            if (map.containsKey(m)) {
                return true;
            }
            if (map.containsKey(m-1) && Math.abs(nums[i]-map.get(m-1)) < w) {
                return true;
            }
            if (map.containsKey(m+1) && Math.abs(nums[i] - map.get(m+1)) < w) {
                return true;
            }
            map.put(m, (long)nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i-k], w));
            }
        }
        return false;
    }// end of containsNearbyAlmostDuplicate       
}







