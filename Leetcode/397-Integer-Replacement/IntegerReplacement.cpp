class Solution {
public:
    int integerReplacement(int n) {
        long int N = n;
        long int small, big;
        int count = 0;
        while (N!=1) {
            small = N & (N-1);
            big = N & (N+1);
            if ((N&1) ==0) {
                N >>=1;
            } else if ( (small&(small-1))<=(big&(big-1)) ) {
                N -=1;
            } else {
                N +=1;
            }
            count++;
        }
        return count;
    }
};
