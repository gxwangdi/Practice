import java.util.HashMap;
import java.util.Map;


public class StringsHomomorphism {
	/**
     * @param s a string
     * @param t a string
     * @return true if the characters in s can be replaced to get t or false
     */
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.length() != t.length())
			return false;
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			if (!map.containsKey(cs)) {
				if (map.containsValue(ct)) {
					return false;
				}
				map.put(cs, ct);
				continue;
			}
			char temp = map.get(cs);
			if (temp != ct)
				return false;
		}
		return true;
	}
}
