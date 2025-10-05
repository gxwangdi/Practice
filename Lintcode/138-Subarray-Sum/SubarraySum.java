import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubarraySum {
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
	public List<Integer> subarraySum(int[] nums) {
		List<Integer> res = new ArrayList<>(2);
		if (nums == null || nums.length == 0) {
			return res;
		}

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				res.add(map.get(sum) + 1);
				res.add(i);
				return res;
			}
			map.put(sum, i);
		}
		return res;
	}
}
