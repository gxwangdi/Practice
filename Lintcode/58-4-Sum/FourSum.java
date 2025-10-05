import java.util.ArrayList;
import java.util.Arrays;


public class FourSum {
	/**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
	public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int left = j + 1;
				int right = nums.length - 1;
				int pSum = nums[i] + nums[j];
				while (left < right) {
					int temp = pSum + nums[left] + nums[right];
					if (temp == target) {
						ArrayList<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);
						res.add(list);
						do {
							right--;
						} while (left < right && nums[right] == nums[right + 1]);
						do {
							left++;
						} while (left < right && nums[left] == nums[left - 1]);
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
    
    
     /*
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if (numbers == null || numbers.length < 4) {
            return res;
        }
        
        // Set<ArrayList<Integer>> set = new HashSet<>();
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int i=0; i<numbers.length-1; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                int key = target - numbers[i] - numbers[j];
                if (map.containsKey(key)) {
                    map.get(key).add(new Pair(i, j));
                } else {
                    List<Pair> value = new ArrayList<>();
                    value.add(new Pair(i, j));
                    map.put(key, value);
                }
            }// end of j loop
        }// end of i loop
        
        for (int k=0; k<numbers.length-1; k++) {
            for (int l=k+1; l<numbers.length; l++) {
                int key = numbers[k] + numbers[l];
                if (!map.containsKey(key)) {
                    continue;
                }
                
                List<Pair> pairs = map.get(key);
                for (Pair p : pairs) {
                    int i = p.i;
                    int j = p.j;
                    if (i!=k && i!=l && j!=k && j!=l) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(numbers[i]);
                        ans.add(numbers[j]);
                        ans.add(numbers[k]);
                        ans.add(numbers[l]);
                        Collections.sort(ans);
                        if (!res.contains(ans)) {
                            res.add(ans);
                        }
                        // set.add(ans);
                    }
                }
            }// end of l loop
        }// end of k loop
        // res.addAll(set);
        return res;
    }
    
    private static class Pair {
        public int i;
        public int j;
        public Pair(int indexi, int indexj) {
            i = indexi;
            j = indexj;
        }
    }// end of Pair.  
    */
}
