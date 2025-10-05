import java.util.ArrayList;
import java.util.Arrays;

public class CountOfSmallerNumber {
	/**
	 * @param A
	 *            : An integer array
	 * @return: The number of element in the array that are smaller that the
	 *          given integer
	 */
	public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
		ArrayList<Integer> res = new ArrayList<>();
		Arrays.sort(A);
		for (int num : queries) {
			res.add(helper(A, num));
		}
		return res;
	}

	public int helper(int[] A, int num) {
		int start = 0;
		int end = A.length - 1;
		int res = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < num) {
				start = mid + 1;
			} else {
				end = mid - 1;
				res = mid;
			}
		}
		return res;
	}
}
