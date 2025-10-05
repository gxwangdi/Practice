import java.util.Arrays;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int[] fre = new int[256];
        Arrays.fill(fre, 0);
        for (int i=0; i<s.length(); i++) {
            fre[s.charAt(i)]++;
        }
        
        int count = 1;
        for (int i : fre) {
            if (i % 2 == 1) {
                count--;
            }
        }
        return count>=0;
    }
}



