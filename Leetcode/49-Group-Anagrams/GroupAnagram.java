import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String s = str;
            s = s.toLowerCase();
            s = s.trim();
            int[] count = new int[26];
            for (int i=0; i<s.length(); i++) {
                count[s.charAt(i)-'a']++;
            }
            
            int hashcode = getHash(count);
            if (!map.containsKey(hashcode)) {
                map.put(hashcode, new ArrayList<String>());
            }
            map.get(hashcode).add(str);
        }
        for (List<String> l : map.values()) {
            res.add(l);
        }
        return res;
    }
    
    private int getHash(int[] count) {
        int hash = 0;
        int a = 378551;
        int b = 63689;
        for (int num : count) {
            hash = hash *a + num;
            a = a*b;
        }
        return hash;
    }
}


