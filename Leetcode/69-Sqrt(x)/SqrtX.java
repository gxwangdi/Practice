public class SqrtX {

    public int mySqrt(int x) {
    // assuming x>0
        long left = 0;
        long right = x;
        long t;
        long mid;
        while (left+1 < right) {
            mid = left + (right-left)/2;
            t = mid*mid;
            if (t == x) {
                return (int)mid;
            } else if (t < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        t = right * right;
        if (t > x) {
            return (int)left;
        }
        return (int)right;
    }

    /* // Newton recursion
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double last = 0.0;
        double res = 1.0;
        while (res != last) {
            last = res;
            res = (res + x/res)/2;
        }
        return (int)res;
    }*/

}
