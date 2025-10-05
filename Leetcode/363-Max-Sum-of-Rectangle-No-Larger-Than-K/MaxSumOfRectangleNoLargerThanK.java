public class MaxSumOfRectangleNoLargerThanK {
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;       
        long[] sum = new long[m+1]; // Stores sum of rect[0...p][i...j]
        for (int i=0; i<n; i++) {
            long[] sumInRow = new long[m];
            for (int j=i; j<n; j++) {
                for (int p=0; p<m; p++) {
                    sumInRow[p] += matrix[p][j];
                    sum[p+1] = sum[p] + sumInRow[p];
                }
                ans = Math.max(ans, mergeSort(sum, 0, m+1, k));
                if (ans == k) {
                    return k;
                }
            }
        }
        return ans;
    }// end of maxSumSubmatrix      
    
    private int mergeSort(long[] sum, int start, int end, int k){
        if (end == start+1) {
            return Integer.MIN_VALUE; // need at least 2 to p. 
        }
        int mid = start + (end-start)/2;
        int cnt = 0;
        int ans = mergeSort(sum, start, mid, k);     
        if (ans == k) {
            return k;
        }
        ans = Math.max(ans, mergeSort(sum, mid, end, k));    
        if (ans == k) {
            return k;
        }
        long[] cache = new long[end-start];
        for (int i=start, j=mid, p=mid; i<mid; i++) {
            while (j < end && sum[j] - sum[i] <= k) {
                j++;
            }
            if (j-1 >= mid) {
                ans = Math.max(ans, (int)(sum[j-1] - sum[i]));
                if (ans == k) {
                    return k;
                }
            }
            while (p < end && sum[p] < sum[i]) {
                cache[cnt++] = sum[p++];
            }
            cache[cnt++] = sum[i];
        }
        System.arraycopy(cache, 0, sum, start, cnt);
        return ans;
    }// end of mergeSort
}






