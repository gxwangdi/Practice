import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length()<3) {
            return s.length();
        }
        int i =0; 
        int j =1;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        addToWindow(map, s.charAt(i));
        addToWindow(map, s.charAt(j));
        while (j<s.length()) {
            if (map.size() > 2) {
                removeFromWindow(map, s.charAt(i));
                i++;
                continue;
            }
            max = Math.max(max, j-i+1);      
            j++;
            if (j == s.length()) {
                continue;
            }
            addToWindow(map, s.charAt(j));
        }
        return max;
    }// end  
    
    private void addToWindow(Map<Character, Integer> map, char c) {
        if (!map.containsKey(c)) {
            map.put(c, 1);
        } else {
            map.put(c, map.get(c)+1);
        }
    }// end of addToWindow
    
    private void removeFromWindow(Map<Character, Integer> map, char c) {
        if (!map.containsKey(c)) {
            return;
        }
        int fre = map.get(c);
        if (fre > 1) {
            map.put(c, fre-1);
        } else {
            map.remove(c);
        }
    }// end of removeFromWindow
}








