
public class HappyNumber {
	/**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        int slow = n;
        int fast = getHappy(n);
        while (slow != fast) {
            slow = getHappy(slow);
            fast = getHappy(getHappy(fast));
        }
        return slow == 1;
    }
    private int getHappy(int n) {
        int res = 0;
        while (n != 0) {
            int digit = n % 10;
            digit = digit * digit;
            res += digit;
            n /= 10;
        }
        return res;
    }
}
