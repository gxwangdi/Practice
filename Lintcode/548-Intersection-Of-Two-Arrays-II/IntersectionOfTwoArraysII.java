import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IntersectionOfTwoArraysII {
	/**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return new int[0];
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums1) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		List<Integer> res = new ArrayList<>();
		for (int i : nums2) {
			if (!map.containsKey(i)) {
				continue;
			}
			res.add(i);
			int f = map.get(i);
			if (f == 1) {
				map.remove(i);
			} else {
				map.put(i, f - 1);
			}
		}// end of nums2 loop

		int[] resArr = new int[res.size()];
		for (int i = 0; i < resArr.length; i++) {
			resArr[i] = res.get(i);
		}
		return resArr;
	}
}
