import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('9', '6');
        map.put('6', '9');
        Set<String> set = new HashSet<>();
        
        generateStrob(set, map, "", "", n);
        for (String s : set) {
            if ("0".equals(s) || !s.startsWith("0")) {
                res.add(s);
            }
        }
        return res;
    }
    
    private void generateStrob(Set<String> res
        , Map<Character, Character> charMap
        , String left
        , String right
        , int length) {
        if (length <=0) {
            res.add(left+right);
            return;
        }
        if (length == 1) {
            for (Map.Entry<Character, Character> entry : charMap.entrySet()) {
                char key = entry.getKey();
                if (key == '6' || key == '9') {
                    continue;
                }
                String s = left + key + right;
                res.add(s);
            }
            return;
        } 
        for (Map.Entry<Character, Character> entry : charMap.entrySet()) {
            char key = entry.getKey();
            char value = entry.getValue();
            generateStrob(res, charMap, left+key, value+right, length-2);
        }
    }
}



