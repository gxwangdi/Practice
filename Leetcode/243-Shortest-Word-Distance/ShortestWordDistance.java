public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        if (words == null || words.length <2) {
            return min;
        }
        int cur1 = -1;
        int cur2 = -1;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                cur1 = i;
                if (cur2 !=-1) {
                    min = Math.min(min, Math.abs(cur1-cur2));
                }
                continue;
            }
            if (words[i].equals(word2)) {
                cur2 = i;
                if (cur1 !=-1) {
                    min = Math.min(min, Math.abs(cur1-cur2));
                }
                continue;
            }
        }
        return min;
    }
}



