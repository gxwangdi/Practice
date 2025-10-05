public class Solution {
    
    
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