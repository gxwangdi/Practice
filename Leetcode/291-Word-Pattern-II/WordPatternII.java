import java.util.HashMap;
import java.util.Map;

public class WordPatternII {
    
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        return isMatch(pattern, str, map);
    }
    
    private boolean isMatch(String p, String s, Map<Character, String> map) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (map.containsKey(p.charAt(0))) {
            String value = map.get(p.charAt(0));
            if (value.length() > s.length() || !s.substring(0, value.length()).equals(value)) {
                return false;
            }
            return isMatch(p.substring(1), s.substring(value.length()), map);
        } else {
            //  Recrusive DFS.   
            for (int i=1; i<=s.length(); i++) {
                if ( map.containsValue(s.substring(0,i)) ) {
                    continue;
                }
                map.put(p.charAt(0), s.substring(0,i));
                if ( isMatch(p.substring(1), s.substring(i), map) ) {
                    return true;
                }
                map.remove(p.charAt(0));
            }
        }
        return false;
    }
    
    /*
    // It is like pattern, not necessary every pattern match has equal size. 
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        if (str.length()%pattern.length()!=0) {
            return false;
        }
        int size = str.length()/pattern.length();
        Map<Character, String> map = new HashMap<>();
        int cur = 0;
        while (cur < pattern.length()) {
            char c = pattern.charAt(cur);
            String s = str.substring(cur*size, cur*size+size);
            if (map.containsKey(c)) {
                String v = map.get(c);
                if (!v.equals(s)) {
                    return false;
                }
            } else {
                if (map.containsValue(s)) {
                    return false;
                }
                map.put(c, s);
            }
            cur++;
        }
        return true;
    }
    */
}





