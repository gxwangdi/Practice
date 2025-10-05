
public class ClosestNumberInSortedArray {
	/**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        if (target <= A[0]) {
            return 0;
        }
        if (target >= A[A.length - 1]) {
            return A.length - 1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int minStart = Math.abs(target - A[start]);
        int minEnd = Math.abs(target - A[end]);
        if (minStart < minEnd) {
            return start;
        }
        return end;
    }
}
