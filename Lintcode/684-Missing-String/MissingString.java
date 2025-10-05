import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingString {
	/*
     * @param : a given string
     * @param : another given string
     * @return: An array of missing string
     */
	public List<String> missingString(String str1, String str2) {
		List<String> result = new ArrayList<>();
		// Assume both string input are valid.

		String shortStr = str1.length() > str2.length() ? str2 : str1;
		String longStr = str1.length() > str2.length() ? str1 : str2;
		String[] tokens = shortStr.split(" ");
		Set<String> set = new HashSet<>();
		for (String s : tokens) {
			set.add(s);
		}
		tokens = longStr.split(" ");
		for (String s : tokens) {
			if (!set.contains(s)) {
				result.add(s);
			}
		}
		return result;
	}
}
