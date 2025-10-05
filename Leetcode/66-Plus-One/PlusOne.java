import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
        
        if (digits[digits.length-1]<9) {
            digits[digits.length-1]++;
            return digits;
        }
        int i = digits.length-1;
        while (i>=0) {
            if (digits[i] == 9) {
                digits[i] = 0;
                i--;
            } else {
                digits[i] ++;
                break;
            }
        }
        if (i == -1) {
            int[] nd = new int[digits.length+1];
            // System.arrayCopy(digits, 0, nd, 1, digits.length);
            Arrays.fill(nd, 0);
            nd[0] = 1;
            return nd;
        }
        return digits;
    }// end of plusOne
}