
public class SystemLongestFilePath {
	/**
	 * @param input: an abstract file system
	 * 
	 * @return: return the length of the longest absolute path to file
	 */
	public int lengthLongestPath(String input) {
		String[] paths = input.split("\n");
		int[] stack = new int[paths.length + 1];
		int maxLen = 0;
		for (String s : paths) {
			int lev = s.lastIndexOf("\t") + 1;
			int curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
			if (s.contains(".")) {
				maxLen = Math.max(maxLen, curLen - 1);
			}
		}
		return maxLen;
	}// end of lengthLongestPath
}
