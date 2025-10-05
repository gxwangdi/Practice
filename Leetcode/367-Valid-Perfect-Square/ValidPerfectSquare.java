public class ValidPerfectSquare {
    
    
    
    /*// n*n == 1+3+....+(2n-1)   Time O(sqrt(n)) 
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        int i = 1;
        while (num>0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }*/
    
    
    /* // Time O(logn)
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }*/
    
    
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        long left = 0, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2, t = mid * mid;
            if (t == num) return true;
            else if (t < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
    
    /* // iterative binary search.  Failed at 808201 
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        int left = 0;
        int right = num;
        while (left +1 < right) {
            int mid = left + (right-left)/2;
            long t = mid*mid;
            if (t == num) {
                return true;
            } else if (t < num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left*left == num) || (right*right == num);
    }*/
    
    
    
    /* // recursive bnary search.  Failed at 808201. 
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        return binarySearch(0, num, num);
    }
    
    private boolean binarySearch(int start, int end, int target) {
        if (start+1==end || start == end) {
            return (start*start == target) || (end*end == target);
        }
        int mid = start + (end - start)/2;
        long res = mid * mid;
        if (res == target) {
            return true;
        } else if (res > target) {
            return binarySearch(start, mid-1, target);
        } else {
            return binarySearch(mid+1, end, target);
        }
    }*/
}




