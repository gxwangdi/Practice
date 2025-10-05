import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('8', '8');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        int left = 0;
        int right = num.length()-1;
        while (left <= right) {
            char l = num.charAt(left);
            if (!map.containsKey(l)) {
                return false;
            }
            char r = num.charAt(right);
            if (r != map.get(l)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}



