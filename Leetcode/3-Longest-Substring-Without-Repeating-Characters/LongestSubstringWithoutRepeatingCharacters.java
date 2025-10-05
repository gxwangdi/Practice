public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[] flag = new boolean[256];
        int res = 0;
        int start = 0;
        int len = s.length();
        for (int i=0; i<len; i++) {
            char cur = s.charAt(i);
            if (!flag[cur]) {
                flag[cur] = true;
                continue;
            }
            res = Math.max(res, i-start);
            for (int j=start; j<i; j++) {
                char c = s.charAt(j);
                if (c == cur) {
                    start = j+1;
                    break;
                }
                flag[c] = false;
            }
        }
        res = Math.max(res, len - start);
        return res;
    }
    
    
    /*
    // My implementation is over complecated. 
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        int max = 0;
        if (s == null || s.length() ==0) {
            return max;
        }
        
        int slow = 0;
        int fast = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(slow), 1);
        max = 1;
        
        while (fast < s.length()) {
            // move fast forward until there is a repeated char
            while (fast < s.length() && !isRepeated(map)) {
                char c = s.charAt(fast);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c)+1);
                } else {
                    map.put(c, 1);
                }
                fast++;
            }
            max = Math.max(max, fast-slow-1);
            if (fast == s.length()) {
                break;
            }
            // move slow forward until it is back to non-repeated.
            char last = s.charAt(fast-1);
            char cur = s.charAt(slow);
            while (slow < fast && cur!=last) {
                map.put(cur, map.get(cur)-1);
                slow++;
                cur = s.charAt(slow);
            }
            map.put(cur, map.get(cur)-1);
            slow++;
        }
        return max;
    }
    
    
    private boolean isRepeated(Map<Character, Integer> map) {
        for (Character c : map.keySet()) {
            if (map.get(c) > 1) {
                return true;
            }
        }
        return false;
    }
    */
}





