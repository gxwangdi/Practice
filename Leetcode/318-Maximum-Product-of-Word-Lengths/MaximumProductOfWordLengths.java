public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }
        
        int len = words.length;
        int[] chars = new int[len];
        for (int i=0; i<len; i++) {
            chars[i] = 0;
            for (int j=0; j<words[i].length(); j++) {
                chars[i] |= 1<<(words[i].charAt(j)-'a');
            }
        }
        
        int max = 0;
        for (int i=0; i<len-1; i++) {
            for (int j=i+1; j<len; j++) {
                if ( (chars[i] & chars[j]) != 0) {
                    continue;
                }
                if ( words[i].length() * words[j].length()<max ) {
                    continue;
                }
                max = words[i].length()*words[j].length();
            }
        }
        return max;
    }// end of maxProduct   
}





