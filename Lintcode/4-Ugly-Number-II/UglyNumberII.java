import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
	/**
     * @param n an integer
     * @return the nth prime number as description.
     */
	public int nthUglyNumber(int n) {
		if (n <= 0) {
			return 0;
		}
		List<Integer> res = new ArrayList<>(n);
		res.add(1);
		int cur = 2;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		while (res.size() < n) {
			while (res.get(index2) * 2 < cur) {
				index2++;
			}
			int res2 = res.get(index2) * 2;
			while (res.get(index3) * 3 < cur) {
				index3++;
			}
			int res3 = res.get(index3) * 3;
			while (res.get(index5) * 5 < cur) {
				index5++;
			}
			int res5 = res.get(index5) * 5;

			int min = Math.min(Math.min(res2, res3), res5);
			cur = min + 1;
			res.add(min);
		}
		return res.get(n - 1);
	}
}
