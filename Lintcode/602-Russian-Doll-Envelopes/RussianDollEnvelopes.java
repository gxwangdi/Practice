import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
	/**
	 * @param envelopes a number of envelopes with widths and heights
	 * @return the maximum number of envelopes
	 */
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0)
			return 0;

		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0]; // ascending order
				} else {
					return b[1] - a[1]; // descending order
				}
			}
		});

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < envelopes.length; i++) {

			if (list.size() == 0 || list.get(list.size() - 1) < envelopes[i][1])
				list.add(envelopes[i][1]);

			int l = 0;
			int r = list.size() - 1;

			while (l < r) {
				int m = l + (r - l) / 2;
				if (list.get(m) < envelopes[i][1]) {
					l = m + 1;
				} else {
					r = m;
				}
			}

			list.set(r, envelopes[i][1]);
		}

		return list.size();
	}
}
