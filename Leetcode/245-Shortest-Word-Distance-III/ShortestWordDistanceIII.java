public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (word1!=null && word1.equals(word2)) {
            return swd3(words, word1);
        }
        return swd1(words, word1, word2);
    }// end of shortestWordDistance    
    
    private int swd3(String[] words, String word) {
        int min = Integer.MAX_VALUE;
        int[] index = new int[2];
        int cur = 0;
        for (int i=0; i<words.length; i++) {
            if (!words[i].equals(word)) {
                continue;
            }
            index[cur%2] = i;
            cur++;
            if (cur>=2) {
                min = Math.min(min, Math.abs(index[0] - index[1]));
            }
        }
        return min;
    }
    
    private int swd1(String[] words, String w1, String w2) {
        int min = Integer.MAX_VALUE;
        int cur1 = -1;
        int cur2 = -1;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(w1)) {
                cur1 = i;
                if (cur2!=-1) {
                    min = Math.min(min, Math.abs(cur1-cur2));
                }
                continue;
            }
            if (words[i].equals(w2)) {
                cur2 = i;
                if (cur1!=-1) {
                    min = Math.min(min, Math.abs(cur1-cur2));
                }
            }
        }
        return min;
    }
}




