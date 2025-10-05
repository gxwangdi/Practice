
public class CompareString {
	/**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return false;
        }
        int[] chars = new int[256];
        for (int i = 0; i < B.length(); i++) {
            chars[B.charAt(i)]--;
        }
        for (int i = 0; i < A.length(); i++) {
            chars[A.charAt(i)]++;
        }
        for (int i : chars) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
