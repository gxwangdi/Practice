public class ScrambleString {
    
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length()!= s2.length()) {
            return false;
        }
        int[] letters = new int[26];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        
        for (int i:letters) {
            if (i!=0) {
                return false;
            }
        }
        // Above verify if s1 and s2 are anagram
        
        for (int i=1; i<s1.length(); i++) {
            // Pay attention to these two possible case, this is where this problem is different from a normal anagram problem. 
            if (isScramble(s1.substring(0,i), s2.substring(0,i)) 
                && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) 
                && isScramble(s1.substring(i), s2.substring(0, s2.length()-i))) {
                return true;
            }
        }
        return false;
    }
    
    /* // my implementation does not work for now.    
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return isScramble(s1, s2, 0, s1.length()); // s1.substring(0, s1.length())
    }
    
    private boolean isScramble(String s1, String s2, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (start + 1 == end) {
            return s1.charAt(start) == s2.charAt(start);
        }
        int[] count = new int[26];
        for (int i=start; i<end; i++) {
            int index = s1.charAt(i) - 'a';
            count[index]++;
            index = s2.charAt(i) - 'a';
            count[index]--;
            if (count[index] != 0) {
                continue;
            }
            if (isAnagram(count)) { // possible split
                if (i+1 == end) {
                    return isReverse(s1, s2, start, end-1);
                } else if (isScramble(s1, s2, start, i+1) && isScramble(s1, s2, i+1, end)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isReverse(String s1, String s2, int start, int end) {
        int cur1 = start;
        int cur2 = end;
        while (cur1 <= end) {
            if (s1.charAt(cur1) != s2.charAt(cur2)) {
                return false;
            }
            cur1++;
            cur2--;
        }
        return true;
    }
    
    private boolean isAnagram(int[] count) {
        for (int i: count) {
            if (i!=0) {
                return false;
            }
        }
        return true;
    }
    */
}


