import java.util.ArrayList;
import java.util.List;

public class SingleNumberIII {
	/**
	 * @param A
	 *            : An integer array
	 * @return : Two integers
	 */
	public List<Integer> singleNumberIII(int[] A) {
		List<Integer> res = new ArrayList<>();
		if (A == null || A.length == 0) {
			return res;
		}
		int mix = 0;
		for (int a : A) {
			mix ^= a;
		}
		int shift = 0;
		while (shift < 32 && ((mix >> shift & 1) == 0)) {
			shift++;
		}
		List<Integer> arr1 = new ArrayList<>();
		List<Integer> arr2 = new ArrayList<>();
		for (int a : A) {
			if ((a >> shift & 1) == 0) {
				arr2.add(a);
			} else {
				arr1.add(a);
			}
		}
		mix = 0;
		for (Integer i : arr1) {
			mix ^= i;
		}
		res.add(mix);
		mix = 0;
		for (Integer i : arr2) {
			mix ^= i;
		}
		res.add(mix);
		return res;
	}
}
