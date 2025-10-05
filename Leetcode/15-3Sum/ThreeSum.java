import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    
    /* // For case that requires index, then cannot sort.  Map approach. 
    // Time Limit exceeds.   
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length<3) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int balance = 0-nums[i];
            if (!map.containsKey(balance)) {
                map.put(balance, i);
            }
            // map.put(balance, i);
        }
        
        Set<List<Integer>> duplicateSet = new HashSet<>();
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (!map.containsKey(sum)) {
                    continue;
                }
                int index = map.get(sum);
                if (index == i || index == j) {
                    continue;
                }
                List<Integer> list = new ArrayList<>(3);
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[index]);
                Collections.sort(list);
                if (!duplicateSet.contains(list)) {
                    res.add(list);
                    duplicateSet.add(list);
                }
                // res.add(list);
            }
        }
        return res;
    }*/
    
      // Two pointers approach
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length<3) {
            return res;
        }
        
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-2; i++) {
            if (i!=0 && nums[i] == nums[i-1]) {
                continue;
            } // skip duplicate   
            int j = i+1;
            int k = nums.length-1;
            while (j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                    while (j<k && nums[j] == nums[j-1])
                        j++;
                    while (j<k && nums[k] == nums[k+1])
                        k--;
                } else if (sum<0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }// 
    
}




