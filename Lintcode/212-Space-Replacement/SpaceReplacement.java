
public class SpaceReplacement {
	/**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
	public int replaceBlank(char[] string, int length) {
		if (string == null || string.length == 0) {
			return length;
		}
		int newLen = length;
		for (int i = 0; i < length; i++) {
			if (string[i] == ' ') {
				newLen += 2;
			}
		}
		int newIndex = newLen - 1;
		int oldIndex = length - 1;
		while (oldIndex >= 0) {
			if (string[oldIndex] != ' ') {
				string[newIndex] = string[oldIndex];
				newIndex--;
				oldIndex--;
			} else {
				string[newIndex--] = '0';
				string[newIndex--] = '2';
				string[newIndex--] = '%';
				oldIndex--;
			}
		}
		return newLen;
	}
}
