import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
	/**
	 * @param digits
	 *            A digital string
	 * @return all posible letter combinations
	 */
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return res;
		}

		res.add("");
		Map<Character, String> map = getMappings();
		for (int i = 0; i < digits.length(); i++) {
			ArrayList<String> level = new ArrayList<>();
			char c = digits.charAt(i);
			String value = map.get(c);
			if (value == null) {
				continue;
			}
			for (int j = 0; j < res.size(); j++) {
				for (int k = 0; k < value.length(); k++) {
					level.add(res.get(j) + value.charAt(k));
				}
			}
			res = level;
		}
		return res;
	}

	private Map<Character, String> getMappings() {
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		map.put('0', " ");
		return map;
	}
}
