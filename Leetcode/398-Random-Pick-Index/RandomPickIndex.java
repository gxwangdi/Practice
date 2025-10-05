import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex {

    Random rand ;
    Map<Integer, List<Integer>> map ;
    
    public RandomPickIndex(int[] nums) {
        rand = new Random();
        map = new HashMap<>();     
        for (int i=0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>(4))
                .add(i);
        }
    }// end of Solution  
    
    public int pick(int target) {
        List<Integer> integers = map.get(target);
        return integers.get( rand.nextInt(integers.size()) );
    }
    
    /*
    Map<Integer, List<Integer>> repo;
    Random rand;
    
    public Solution(int[] nums) {
        repo = new HashMap<>();
        rand = new Random();
        if (nums != null && nums.length > 0) {
            for (int i=0; i<nums.length; i++) {
                if (!repo.contains(nums[i])) {
                    repo.put(nums[i], new ArrayList<Integer>());
                }
                repo.get(nums[i]).add(i);
            }
        }
    }// end of Solution     
    
    public int pick(int target) {
        if (!repo.contains(target)) {
            return -1;
        }
        List<Integer> res = repo.get(target);
        if (res.size() == 1) {
            return res.get(0);
        }
        int index = rand.nextInt(res.size());
        return res.get(index);
    }// end of pick    
    
    */
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
 
 
 
 
 
 
 
 