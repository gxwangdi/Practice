import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    /* Brute force   
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length<2)
            return false;
        
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<Math.min(i+k, nums.length); j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }*/
    
    /*
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length>2) 
            return false;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<Math.min(k, nums.length); i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            queue.add(nums[i]);
        }
        for (int i=k; i<nums.length; i++) {
            int temp = queue.poll();
            set.remove(temp);
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            queue.add(nums[i]);
        }
        return false;
    }*/
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 0 || k <= 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
                
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}