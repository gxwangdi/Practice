
public class MergeTwoSortedArrays {
	/**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || A.length == 0) {
            return B;
        }
        if (B == null || B.length == 0) {
            return A;
        }
        int[] C = new int[A.length + B.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < C.length; i++) {
            if (b >= B.length || (a < A.length && A[a] < B[b])) {
                C[i] = A[a];
                a++;
            } else {
                C[i] = B[b];
                b++;
            }
        }
        return C;
    }
}
