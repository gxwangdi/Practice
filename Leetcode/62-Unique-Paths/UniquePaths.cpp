class Solution {
public:
    int uniquePaths(int m, int n) {
        if (m<=0 || n<=0) {
            return 0;
        }
        int N = n+m-2;
        int k = m-1;
        double res = 1.0d;
        for (int i=1; i<=k; i++) {
            res = res*(N-k+i)/i;
        }
        return (int)res;
    }
};
