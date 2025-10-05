
public class AddBinary {
	/**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        StringBuilder sb = new StringBuilder(
            Math.max(a.length(), b.length()) + 1);
        int i = -1;
        if (a != null) {
            i = a.length()-1;
        }
        int j = -1;
        if (b != null) {
            j = b.length()-1;
        }
        int carry = 0;
        while (i>=0 || j>=0) {
            int sum =0;
            if (i>=0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j>=0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            sum += carry;
            carry = sum/2;
            sb.append(sum%2);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    
}
