
public class LeftPad {
	/**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        return leftPad(originalStr, size, ' ');
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        StringBuilder sb = new StringBuilder(size);
        int diff = size - originalStr.length();
        while (diff > 0 ) {
            sb.append(padChar);
            diff--;
        }
        sb.append(originalStr);
        return sb.toString();
    }
}
