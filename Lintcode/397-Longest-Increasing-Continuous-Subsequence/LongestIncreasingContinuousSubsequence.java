
public class LongestIncreasingContinuousSubsequence {
	/**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        int max = 0;
        if (A == null || A.length == 0) {
            return max;
        }
        int iCount = 1;
        int dCount = 1;
        for (int i=1; i<A.length; i++) {
            if (A[i] > A[i-1]) {
                iCount++;
                max = Math.max(max, dCount);
                dCount = 1;
            } else {
                dCount++;
                max = Math.max(max, iCount);
                iCount = 1;
            }
        }
        max = Math.max(max, Math.max(iCount, dCount));
        return max;
    }
}
