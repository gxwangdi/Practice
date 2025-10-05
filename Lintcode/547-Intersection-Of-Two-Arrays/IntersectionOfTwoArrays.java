import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class IntersectionOfTwoArrays {
	/**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return new int[0];
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> list = new ArrayList<>();
		int cur1 = 0;
		int cur2 = 0;
		int last = Integer.MIN_VALUE;
		while (cur1 < nums1.length && cur2 < nums2.length) {
			if (nums1[cur1] == nums2[cur2] && nums1[cur1] != last) {
				list.add(nums1[cur1]);
				last = nums1[cur1];
				cur1++;
				cur2++;
				continue;
			}
			if (nums1[cur1] < nums2[cur2]) {
				cur1++;
			} else {
				cur2++;
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
