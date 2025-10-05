
public class PalindromeNumber {
	/**
     * @param num a positive number
     * @return true if it's a palindrome or false
     */
    public boolean palindromeNumber(int num) {
        if (num < 0 || (num >= 10 && num % 10 == 0)) {
            return false;
        }
        int sum = 0;
        while (num > sum) {
            sum = sum * 10 + num % 10;
            num = num / 10;
        }
        return sum / 10 == num || sum == num;
    }
}
