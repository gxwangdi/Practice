class Solution {
public:
    double myPow(double x, int n) {
        if (x == 1.0) { //TODO: check double comparison.
            return 1.0;
        }
        if (n<0) {
            return 1/power(x, -long(n));
        } else {
            return power(x, n);
        }
    }
private:
    double power(double x, long n) {
        if (n==0) {
            return 1;
        }
        double v = power(x, n/2);
        if (n%2 == 0) {
            return v*v;
        } else {
            return v*v*x;
        }
    }
};
