
public class RotateString {
	/**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
	public void rotateString(char[] str, int offset) {
		if (offset <= 0 || str == null || str.length < 2) {
			return;
		}
		offset = offset % str.length;
		reverse(str, str.length - offset, str.length - 1);
		reverse(str, 0, str.length - offset - 1);
		reverse(str, 0, str.length - 1);
	}

	private void reverse(char[] str, int start, int end) {
		while (start < end) {
			char c = str[start];
			str[start] = str[end];
			str[end] = c;
			start++;
			end--;
		}
	}
}
