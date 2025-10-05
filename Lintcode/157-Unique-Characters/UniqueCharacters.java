import java.util.HashSet;
import java.util.Set;


public class UniqueCharacters {
	/**
     * @param str: a string
     * @return: a boolean
     */
	public boolean isUnique(String str) {
		if (str == null || str.length() < 2) {
			return true;
		}

		Set<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}
}
