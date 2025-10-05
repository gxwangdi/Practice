import java.util.HashMap;
import java.util.Map;

public class PermutationIndexII {
	/**
     * @param A an integer array
     * @return a long integer
     */
	public long permutationIndexII(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		long index = 1;// index start from 1
		long fact = 1;
		long multiFact = 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = A.length - 1; i >= 0; i--) {
			if (!map.containsKey(A[i])) {
				map.put(A[i], 1);
			} else {
				map.put(A[i], map.get(A[i]) + 1);
				multiFact *= map.get(A[i]);
			}

			int count = 0;
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j]) {
					count++;
				}
			}
			index += count * fact / multiFact;
			fact *= A.length - i;
		}
		return index;
	}
}
