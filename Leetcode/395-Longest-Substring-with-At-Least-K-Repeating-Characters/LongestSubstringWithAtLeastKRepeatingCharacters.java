import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeastKRepeatingCharacters {      
    
    public int longestSubstring(String s, int k) {
        if (k <= 1) {
            return s.length();
        }
        if (s.length() < k) {
            return 0;
        }
        char[] c = s.toCharArray();
        int res = 0;
        for (int i=0; i<c.length; i++) {
            int start = i;
            int end = 0;
            int count = 0;
            int minLen = 0;
            Map<Character, Integer> map = new HashMap<>();
            
            for (int pos =i; pos<c.length; pos++) {
                map.put(c[pos], map.getOrDefault(c[pos], 0)+1);
                int val = map.get(c[pos]);
                if (val == k) {
                    count--;
                }
                if (val ==1) {
                    count++;
                }
                
                if (count == 0) {
                    minLen = (pos==start)?0:(pos-start+1);
                    end = pos;
                }
            }// end of pos loop
            if (minLen != 0) {
                i = end;
            }
            res = Math.max(res, minLen);
        }
        return res;
    }// end of longestSubstring       
    
}// end of Solution class     








