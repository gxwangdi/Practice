import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
	/*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		Arrays.fill(res, 0);
		if (numbers == null || numbers.length < 2) {
			return res;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			int key = target - numbers[i];
			if (!map.containsKey(key)) {
				map.put(key, i);
			}
		}
		for (int i = 1; i < numbers.length; i++) {
			if (!map.containsKey(numbers[i])) {
				continue;
			}
			int index = map.get(numbers[i]);
			if (index == i) {
				continue;
			}
			res[0] = Math.min(index, i) + 1;
			res[1] = Math.max(index, i) + 1;
		}
		return res;
	}
}
