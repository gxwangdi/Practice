import java.util.ArrayList;
import java.util.List;

public class SplitString {
	/*
	 * @param : a string to be split
	 * 
	 * @return: all possible split string array
	 */
	public List<List<String>> splitString(String s) {
		List<List<String>> result = new ArrayList<>();
		if (s == null || s.length() == 0) {
			result.add(new ArrayList<String>());
			return result;
		}
		buildSolution(s, 0, new ArrayList<String>(), result);
		return result;
	}

	private void buildSolution(String src, int cur, List<String> solution, List<List<String>> result) {
		if (cur == src.length()) {
			result.add(solution);
			return;
		}
		// take [cur] char
		char c1 = src.charAt(cur);
		String s1 = "" + c1;
		List<String> solution1 = new ArrayList<>(solution);
		solution1.add(s1);
		buildSolution(src, cur + 1, solution1, result);

		// take [cur, cur+1] char
		if (cur + 1 >= src.length()) {
			return;
		}
		char c2 = src.charAt(cur + 1);
		String s2 = "" + c1 + c2;
		List<String> solution2 = new ArrayList<>(solution);
		solution2.add(s2);
		buildSolution(src, cur + 2, solution2, result);
	}
}
