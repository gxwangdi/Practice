public class RearrangeStringKDistanceApart {
    
    public String rearrangeString(String str, int k) {
        int len = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for(int i=0; i<len; i++) {
            count[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int index = 0; index<len; index++) {
            int candidatePos = findValidMax(count, valid, index);
            if (candidatePos == -1) {
                return "";
            }
            count[candidatePos]--;
            valid[candidatePos] = index + k;
            sb.append((char)('a'+candidatePos));
        }
        return sb.toString();
    }
    
    private int findValidMax(int[] count, int[] valid, int index) {
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;
        for (int i=0; i<count.length; i++) {
            if (count[i]>0 && count[i]>max && index >=valid[i]) {
                max = count[i];
                candidatePos = i;
            }
        }
        return candidatePos;
    }// end of findValidMax       
    
    
    /*
    // Naive DFS search,  TLE. 
    public String rearrangeString(String str, int k) {
        if (str == null || str.length()<2) {
            return str;
        }
        
        int[] chars = new int[26]; // chars[c-'a'] assuming all lower case
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            chars[c-'a']++;
        }
        // <char, last_index> in new string.
        Map<Character, Integer> pos = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if (helper(chars, pos, sb, k)) {
            return sb.toString();
        }
        return "";
    }// end 
    
    private boolean helper(int[] chars, Map<Character, Integer> pos, StringBuilder Prog, final int k) {
        int start = getNextAvailableChar(chars, 0);
        if (start == -1) { // Note the exit strategy. 
            return true;
        }
        while (start != -1) {
            char c = (char)(start+'a');  // int convert to char.    
            if (!pos.containsKey(c) || Prog.length() - pos.get(c) >= k) {
                int index = -k; // Note this preprocessing. 
                if (pos.containsKey(c)) {
                    index = pos.get(c);
                }
                pos.put(c, Prog.length());
                chars[start]--;
                Prog.append(c);
                if (helper(chars, pos, Prog, k)) {
                    return true;
                }
                chars[start]++;
                pos.put(c, index);
                Prog.deleteCharAt(Prog.length()-1);
            }
            start = getNextAvailableChar(chars, start+1);
        }
        return false;
    }// end of helper   
    
    // if None, return -1; or starts from index start, get the index of non-zero element. 
    private int getNextAvailableChar(int[] chars, int start) {
        int cur = start;
        while (cur < chars.length) {
            if (chars[cur] > 0) {
                return cur;
            }
            cur++;
        }
        return -1;
    }// end of getNextAvailableChar    
    */
}





