
class MinNumberOfStepsToMakeTwoStringsAnagramII {
    public int minSteps(String s, String t) {
        int[] freqCount = new int[26];
        int answer = 0;
        for(char letter: s.toCharArray()) {
            freqCount[letter-'a']++;
        }
        for(char letter: t.toCharArray()) {
            freqCount[letter-'a']--;
        }
        for(int i=0;i<26;i++) {
            if(freqCount[i] != 0) {
                answer += Math.abs(freqCount[i]);
            }
        }
        return answer;
    }
}
