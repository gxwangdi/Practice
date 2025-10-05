
public class MergeSortedArray {
	/**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] a, int m, int[] b, int n) {
        if (a == null || b == null || a.length < m+n || b.length < n) {
            return;
        }
        
        int index = a.length-1;
        int ai = m-1;
        int bi = n-1;
        while (index >=0) {
            if (bi<0 || (ai>=0 && a[ai]>b[bi])) {
                a[index] = a[ai];
                ai--;
            } else {
                a[index] = b[bi];
                bi--;
            }
            index--;
        }   
    }
}
