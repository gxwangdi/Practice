import java.util.Set;

public class WordBreak {
    
    private int maxWordLength(Set<String> dict) {
        int max = 0;
        if (dict == null || dict.size() ==0) {
            return max;
        }
        for (String s : dict) {
            max = Math.max(max, s.length());
        }
        return max;
    }
    
    // dp with 3 speed up tricks.
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() ==0) {
            return true;
        }
        int maxLen = maxWordLength(wordDict); // speed up 1.
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<=s.length(); i++) {
            dp[i] = false;
            for (int lastWordLength = 1;
                lastWordLength<=maxLen && lastWordLength<=i;
                lastWordLength++) {
                if (!dp[i-lastWordLength]) { // speed up 2.
                    continue;
                }
                String temp = s.substring(i-lastWordLength, i);
                if (wordDict.contains(temp)) {
                    dp[i] = true;
                    break; // speed up 3.
                }
            }
        }
        return dp[s.length()];
    }
    
    /* // dfs approach.   
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() ==0) {
            return true;
        }
        boolean res = false;
        for (int i=1; i<=s.length(); i++) {
            String sub = s.substring(0, i);
            if (!wordDict.contains(sub)) {
                continue;
            }
            res |= wordBreak(s.substring(i), wordDict);
        }
        return res;
    }*/
}




