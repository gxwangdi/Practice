import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbreviation {

    private Map<String, Set<String>> map;
    
    public ValidWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        if (dictionary != null) {
            for (String s:dictionary) {
                String abb = getAbbreviation(s);
                if (map.containsKey(abb)) {
                    Set<String> set = map.get(abb);
                    set.add(s);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(s);
                    map.put(abb, set);
                }
            }
        }
    }
    
    private String getAbbreviation(String s) {
        if (s == null || s.length() <3) {
            return s;
        }
        int len = s.length()-2;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(len);
        sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }

    public boolean isUnique(String word) {
        String abb = getAbbreviation(word);
        if (!map.containsKey(abb))  {
            return true;
        }
        Set<String> set = map.get(abb);
        for (String s : set) {
            if (!s.equals(word)) {
                return false;
            }
        }
        return true;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");