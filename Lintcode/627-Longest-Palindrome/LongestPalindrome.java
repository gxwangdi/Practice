import java.util.HashMap;
import java.util.Map;


public class LongestPalindrome {
	/**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) + 1);
            } else {
                counts.put(c, 1);
            }
        }
        int couple = 0;
        int core = 0;
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            couple += entry.getValue() / 2;
            core = Math.max(core, entry.getValue() % 2);
        }
        return 2 * couple + core;
    }
}
