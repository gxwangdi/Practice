import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MajorityNumberIII {
	/**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
	public int majorityNumber(ArrayList<Integer> nums, int k) {
		int res = Integer.MIN_VALUE;
		if (nums == null || nums.size() == 0 || k <= 0) {
			return res;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		int maxFrequency = 0;
		for (Integer key : map.keySet()) {
			if (map.get(key) > maxFrequency) {
				res = key;
				maxFrequency = map.get(key);
			}
		}
		if (maxFrequency > nums.size() / k) {
			return res;
		}
		return Integer.MIN_VALUE;
	}
}
