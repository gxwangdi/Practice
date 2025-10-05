import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RotateWords {
	/*
	 * @param words: A list of words
	 * 
	 * @return: Return how many different rotate words
	 */
	public int countRotateWords(List<String> words) {
		Set<String> set = new HashSet<>();
		for (String word : words) {
			String s = getAnchor(word);
			if (!set.contains(s)) {
				set.add(s);
			}
		}
		return set.size();
	}

	// Get the value with minimum hashcode as anchor
	private String getAnchor(String word) {
		int minHashCode = word.hashCode();
		String candidate = word.toLowerCase();
		String cur = candidate;
		for (int i = 0; i < word.length(); i++) {
			char[] charArr = rotateString(cur.toCharArray(), 1);
			cur = new String(charArr);
			int hashCode = cur.hashCode();
			if (hashCode < minHashCode) {
				minHashCode = hashCode;
				candidate = cur;
			}
		}

		return candidate;
	}

	private char[] rotateString(char[] A, int offset) {
		if (A == null || A.length == 0) {
			return A;
		}
		int len = A.length;
		offset %= len;
		reverse(A, 0, len - offset - 1);
		reverse(A, len - offset, len - 1);
		reverse(A, 0, len - 1);
		return A;
	}

	private void reverse(char[] str, int start, int end) {
		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
}
