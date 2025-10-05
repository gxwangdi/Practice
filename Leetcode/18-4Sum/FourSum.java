import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    /* // Map approach. O(n2)   Need to deal with duplicate elements. 
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();   
        if (nums == null || nums.length <4) {
            return res;
        }
        Arrays.sort(nums);
        Map<Integer, Pair> map = new HashMap<>();
        for (int i=0; i<nums.length-1; i++) {
            if (i!=0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j=i+1; j<nums.length; j++) {
                if (j!=i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int temp = target - nums[i] - nums[j];
                if (!map.containsKey(temp)) {
                    map.put(temp, new Pair(i, j));
                }
            }
        }
        
        for (int i=0; i<nums.length-1; i++) {
            
            // if (i!=0 && nums[i] == nums[i-1]) {
            //     continue;
            // }
            for (int j=i+1; j<nums.length; j++) {
                // if (j!=i+1 && nums[j] == nums[j-1]) {
                //     continue;
                // }
                int temp = nums[i] + nums[j];
                if (!map.containsKey(temp)) {
                    continue;
                }
                Pair pair = map.get(temp);
                if (pair.index1 == i || pair.index2 == j) {
                    continue;
                }
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[pair.index1]);
                list.add(nums[pair.index2]);
                list.add(nums[i]);
                list.add(nums[j]);
                Collections.sort(list);
                if (!res.contains(list)) {
                    res.add(list);
                }
            }
        }
        return res; 
    }
    
    private static class Pair {
        public int index1;
        public int index2;
        public Pair (int i1, int i2) {
            index1 = i1;
            index2 = i2;
        }
    }
    */
    
     // two pointer O(n3) approach. 
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <4) {
            return res;
        }
        Arrays.sort(nums);    
        for (int i=0; i<nums.length-3; i++) {
            if (i!=0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j=i+1; j<nums.length-2; j++) {
                if (j!= i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                int pSum = nums[i] + nums[j];
                while (left < right) {
                    int temp = pSum + nums[left] + nums[right];
                    if (temp == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        do {
                            right--;
                        } while ( left<right && nums[right]==nums[right+1]);
                        do {
                            left++;
                        } while (left<right && nums[left]==nums[left-1]);
                    } else if (temp < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }// end of fourSum     
}



