class Solution {
public:
    int maxRotateFunction(vector<int>& A) {
        long int F= 0;
        long int sum = 0;
        long int res = INT_MIN;
        int n = A.size();
        if (n<=1) {
            return 0;
        }
        for (int i=0; i<n; i++) {
            F += i*A[i];
            sum += A[i];
        }
        if (F>res) {
            res = F;
        }
        for (int k=1; k<n; k++) {
            F += sum;
            F -= n*((long)A[n-k]);
            if (F>res) {
                res = F;
            }
        }
        return res;
    }
};
