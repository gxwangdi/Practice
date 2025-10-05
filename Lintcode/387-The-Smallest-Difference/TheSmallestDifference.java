import java.util.Arrays;

public class TheSmallestDifference {
	/**
	 * @param A, B: Two integer arrays.
	 * @return: Their smallest difference.
	 */
	public int smallestDifference(int[] A, int[] B) {
		int min = Math.abs(A[0] - B[0]);
		Arrays.sort(B);
		for (int i = 0; i < A.length; i++) {
			int l = 0, r = B.length - 1;
			while (l <= r) {
				int mid = (l + r) / 2;
				if (B[mid] == A[i]) {
					min = 0;
					break;
				} else if (B[mid] < A[i]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
			if (l > r) {
				if (l > B.length - 1) {
					min = Math.min(min, A[i] - B[r]);
				} else if (r < 0) {
					min = Math.min(min, B[l] - A[i]);
				} else {
					min = Math.min(min, Math.min(A[i] - B[r], B[l] - A[i]));
				}
			}
		}
		return min;
	}
}
