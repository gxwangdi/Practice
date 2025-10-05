class Solution {
public:
    int mySqrt(int x) {
        long long int left = 0;
        long long int right = x;
        long long int t;
        long long int mid;
        while (left+1<right) {
            mid = left +(right-left)/2;
            t = mid*mid;
            if (t == x) {
                return mid;
            }
            if (t<x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        t = right * right;
        if (t > x) {
            return left;
        }
        return right;
    }
};
