
class NumOfStringsThatAppearAsSubstringsInWord {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        if (patterns == null || patterns.length < 1) {
            return count;
        }
        for(String str : patterns) {
            if (word.contains(str)) {
                count++;
            }
        }
        return count;
    }
}
