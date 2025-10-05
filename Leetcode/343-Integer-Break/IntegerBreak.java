public class IntegerBreak {
    
    public int integerBreak(int n) {
        // max[i], the max value we can have for i.
        int[] max = new int[n+1]; 
        max[0] = max[1] = 1;
        for (int i=1; i<=n; i++) {
            int m = 0;
            for (int j=1; j<=i/2; j++) {
                int left = max[j];
                int right = max[i-j];
                m = Math.max(m, left*right); // break both
                m = Math.max(m, j*right); // break one side
                m = Math.max(m, left*(i-j));
                m = Math.max(m, j*(i-j));
            }
            max[i] = m;
        }
        return max[n];   
    }// end of integerBreak     
    
    
    
    /*
    // Works for two factors case. Does not for more than two factors. 
    public int integerBreak(int n) {
        if (n <= 3) {
            return n-1;
        }
        
        return breakInt(n);
    }// end of integerBreak    
    
    private int breakInt(int n) {
        if (n <= 4) {
            return n;
        }
        int h1 = n/2;
        int h2 = n/2;
        if (n%2 == 1) {
            h2++;
        }
        h1 = breakInt(h1);
        h2 = breakInt(h2);
        return h1*h2;
    }
    */
}






