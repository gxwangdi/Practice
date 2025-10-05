import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = createMappings(t);
        int slow = 0;
        int fast = slow + t.length() -1;
        initMappings(s, slow, fast, map);
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        Arrays.fill(res, -1);
        while (fast < s.length()) {
            if (containsAllChars(map)) {
                if (min > fast - slow + 1) {
                    min = fast - slow + 1;
                    res[0] = slow;
                    res[1] = fast;
                }
                char c = s.charAt(slow);
                slow++;
                if (map.containsKey(c)) {
                    map.put(c, map.get(c)+1);
                }
            } else {
                fast++;
                if (fast >= s.length()) {
                    break;
                }
                char c = s.charAt(fast);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c)-1);
                }
            }
        }
        if (res[0] == -1) {
            return "";
        }
        return s.substring(res[0], res[1]+1);
    }
    
    private boolean containsAllChars(Map<Character, Integer> map) {
        for (Character c : map.keySet()) {
            if (map.get(c) > 0) {
                return false;
            }
        }
        return true;
    }
    
    private void initMappings(String s, int start, int end, Map<Character, Integer> map) {
        int cur = start;
        while (cur <= end) {
            char c = s.charAt(cur++);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
            }
        }
    }
    
    private Map<Character, Integer> createMappings(String s) {
        Map<Character, Integer> res = new HashMap<>();
        if (s == null || s.length() ==0) {
            return res;
        }
        for (int i =0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (res.containsKey(c)) {
                res.put(c, res.get(c)+1);
            } else {
                res.put(c, 1);
            }
        }
        return res;
    }
}



