import java.util.Arrays;


public class FirstPositionUniqueCharacter {
	private final int INIT_VAL = -2;
    private final int INVA_VAL = -1;
    /**
     * @param s a string
     * @return it's index
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return INVA_VAL;
        }
        int[] index = new int[256];
        Arrays.fill(index, INIT_VAL);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index[c] >= 0) {
                index[c] = INVA_VAL;
            }
            if (index[c] == INVA_VAL) {
                continue;
            }
            index[c] = i;
        }
        return getMinFromArray(index);
    }
    // src can never be null.
    private int getMinFromArray(final int[] src) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < src.length; i++) {
            if (src[i] < 0) {
                continue;
            }
            min = Math.min(min, src[i]);
        }
        if (min == Integer.MAX_VALUE) {
            return INVA_VAL;
        }
        return min;
    }
}
