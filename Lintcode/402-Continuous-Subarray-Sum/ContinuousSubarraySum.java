import java.util.ArrayList;

public class ContinuousSubarraySum {
	/**
	 * @param A
	 *            an integer array
	 * @return A list of integers includes the index of the first number and the
	 *         index of the last number
	 */
	public ArrayList<Integer> continuousSubarraySum(int[] A) {
		ArrayList<Integer> res = new ArrayList<>();
		if (A == null || A.length == 0) {
			return res;
		}
		int[] arr = new int[3]; // 0 for start, 1 for end, 2 for max sum.
		arr[2] = Integer.MIN_VALUE;
		int start = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			max = Math.max(max, sum);
			if (max > arr[2]) {
				arr[2] = max;
				arr[0] = start;
				arr[1] = i;
			}
			// cap the negative prefix sum.
			if (sum < 0) {
				sum = 0;
				start = i + 1;
			}
		}
		res.add(arr[0]);
		res.add(arr[1]);
		return res;
	}// end of continuousSubarraySum
}
