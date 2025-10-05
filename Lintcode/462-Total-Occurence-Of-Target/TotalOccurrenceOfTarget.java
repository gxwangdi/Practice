
public class TotalOccurrenceOfTarget {
	/**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
	public int totalOccurrence(int[] A, int target) {
		if (A == null || A.length == 0 || target < A[0]
				|| target > A[A.length - 1]) {
			return 0;
		}
		int first = getFirstOccurenceIndex(A, 0, A.length - 1, target);
		if (first == -1) {
			return 0;
		}
		int last = getLastOccurenceIndex(A, first, A.length - 1, target);
		return last - first + 1;
	}

	private int getFirstOccurenceIndex(int[] arr, int start, int end, int target) {
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] >= target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (arr[start] == target) {
			return start;
		}
		if (arr[end] == target) {
			return end;
		}
		return -1;
	}

	private int getLastOccurenceIndex(int[] arr, int start, int end, int target) {
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (arr[end] == target) {
			return end;
		}
		if (arr[start] == target) {
			return start;
		}
		return -1;
	}
}
