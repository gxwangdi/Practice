
public class AddDigits {
    /**
     * @param num a non-negative integer
     * @return one digit
     */
    public int addDigits(int num) {
        while (num >= 10) {
            num = digitSum(num);
        }
        return num;
    }
    private int digitSum(int n) {
        int result = 0;
        while (n > 0) {
            result = result + n % 10;
            n = n / 10;
        }
        return result;
    }
}


