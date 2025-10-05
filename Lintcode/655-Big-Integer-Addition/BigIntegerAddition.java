
public class BigIntegerAddition {
	/**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() < 1) {
            return num2;
        }
        if (num2 == null || num2.length() < 1) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0) {
                char c = num1.charAt(index1);
                carry += c - '0';
            }
            if (index2 >= 0) {
                char c = num2.charAt(index2);
                carry += c - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
            index1 --;
            index2 --;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }// end of addStrings
}
