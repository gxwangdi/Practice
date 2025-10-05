public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int F = 0;
        int sum = 0;
        int res = Integer.MIN_VALUE;
        int n = A.length;
        if ( n<=1 ) {
            return 0;
        }
        for (int i=0; i<n; i++) {
            F += i*A[i];
            sum += A[i];
        }

        if (F > res) {
            res = F;
        }
        for (int k=1; k<n; k++) {
            F += sum;
            F -= n*A[n-k];
            if ( F>res ) {
                res = F;
            }
        }
        return res;
    }// end of maxRotateFunction
}
