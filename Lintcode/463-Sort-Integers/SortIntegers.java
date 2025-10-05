
public class SortIntegers {
	/**
     * @param A an integer array
     * @return void
     */
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
     
    // Insertion sort:
    // public void sortIntegers(int[] A) {
    //     if (A == null || A.length < 2) {
    //         return;
    //     }
    //     for (int i = 1; i < A.length; i++) {
    //         int j = i;
    //         while (j > 0 && A[j-1] > A[j]) {
    //             swap(A, j, j-1);
    //             j --;
    //         }
    //     }
    // }
    
    // Bubble sort:
    // public void sortIntegers(int[] A) {
    //     if (A == null || A.length < 2) {
    //         return;
    //     }
    //     boolean swaped = false;
    //     do {
    //         swaped = false;
    //         for (int i = 1; i < A.length; i++) {
    //             if (A[i-1] > A[i]) {
    //                 swap(A, i-1, i);
    //                 swaped = true;
    //             }
    //         }
    //     } while (swaped);
    // }
    
    // Selection sort:
    public void sortIntegers(int[] A) {
        if (A == null || A.length < 2) {
            return;
        }
        for (int j = 0; j < A.length-1; j++) {
            int iMin = j;
            for (int i = j+1; i < A.length; i++) {
                if (A[i] < A[iMin]) {
                    iMin = i;
                }
            }
            if (iMin != j) {
                swap(A, iMin, j);
            }
        }
    }
}
