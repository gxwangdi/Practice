
class MaxNumberOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        int max =0;
        if (sentences == null || sentences.length < 1) {
            return max;
        }
        for(String s : sentences) {
            max = Math.max(max, countNumberofSpace(s));
        }
        return max+1;
    }

    private int countNumberofSpace(String str) {
        int count = 0;
        for(int i =0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
}
