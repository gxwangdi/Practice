class Solution {
public:
    int reverse(int x) {
        long m = abs((long)x);
        if (m > INT_MAX) {
            return 0;
        }
        long int total = 0;
        while (m>0) {
            int mod = m%10;
            total = total*10 + mod;
            m = m/10;
        }
        if (total > INT_MAX) {
            return 0;
        }
        if (x<0) {
            total *= -1;
        }
        return (int)total;
    }
};
