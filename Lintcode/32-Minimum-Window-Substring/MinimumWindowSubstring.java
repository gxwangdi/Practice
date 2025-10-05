import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	/**
	 * @param source: A string
	 * @param target: A string
	 * @return: A string denote the minimum window Return "" if there is no such
	 *          a string
	 */
	public String minWindow(String source, String target) {
		if (source == null || target == null || source.length() == 0
				|| target.length() == 0) {
			return "";
		}
		Map<Character, Integer> map = getMappings(target);
		if (source.length() < map.size()) {
			return "";
		}
		int slow = 0;
		int fast = slow + map.size() - 1;
		initMappings(source, slow, fast, map);
		int min = Integer.MAX_VALUE;
		int[] res = new int[2];
		Arrays.fill(res, -1);
		while (fast < source.length()) {
			if (containsAllChars(map)) {
				if (min > fast - slow + 1) {
					min = fast - slow + 1;
					res[0] = slow;
					res[1] = fast;
				}
				char c = source.charAt(slow);
				slow++;
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				}
			} else {
				fast++;
				if (fast >= source.length()) {
					continue;
				}
				char c = source.charAt(fast);
				if (map.containsKey(c)) {
					map.put(c, map.get(c) - 1);
				}
			}
		}
		if (res[0] == -1) {
			return "";
		}
		return source.substring(res[0], res[1] + 1);
	}

	private void initMappings(String source, int start, int end,
			Map<Character, Integer> map) {
		int cur = start;
		while (cur <= end) {
			char c = source.charAt(cur++);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
			}
		}
	}

	private boolean containsAllChars(Map<Character, Integer> map) {
		for (Character c : map.keySet()) {
			if (map.get(c) > 0) {
				return false;
			}
		}
		return true;
	}

	private Map<Character, Integer> getMappings(String s) {
		Map<Character, Integer> res = new HashMap<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (res.containsKey(c)) {
				res.put(c, res.get(c) + 1);
			} else {
				res.put(c, 1);
			}
		}
		return res;
	}// end of getMapping
}
