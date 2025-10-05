import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || p == null || p.length() < 1 || s.length() < p.length()) {
			return list;
		}

		int[] hash = new int[256];
		for (char c : p.toCharArray()) {
			hash[c]++;
		}
		// two pointer left and right build a window.
		int left = 0;
		int right = 0;
		int count = p.length();
		while (right < s.length()) {
			if (hash[s.charAt(right)] >= 1) {
				count--;
			}
			hash[s.charAt(right)]--;
			right++;

			if (count == 0) {
				list.add(left);
			}
			if (right - left == p.length()) {
				if (hash[s.charAt(left)] >= 0) {
					count++;
				}
				hash[s.charAt(left)]++;
				left++;
			}
		}
		return list;
	}// end of findAnagrams
}
