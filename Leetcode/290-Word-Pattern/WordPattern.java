import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || pattern.length() ==0 || str.length() ==0) 
            return false;
        
        Map<Character, String> map = new HashMap<>();
        String[] strings = str.split("[ ]");
        if (strings.length != pattern.length())
            return false;
            
        for (int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (map.containsValue(strings[i])) {
                    return false;
                }
                map.put(c, strings[i]);
                continue;
            } 
            String s = map.get(c);
            if (!s.equals(strings[i])) {
                return false;
            }
        }
        return true;
    }
}