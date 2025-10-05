class NumberOfValidWordsInASentence {
    public int countValidWords(String sentence) {
        String[] arr = sentence.split(" ");
        int count = 0;
        for(String s : arr) {
            if (isValid(s)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(String s) {
        if (s == null || s.length() <1) {
            return false;
        }
        boolean dash = false;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                return false;
            }
            if (c == '!' || c == '.' || c == ',') {
                if (i!=s.length()-1) {
                    return false;
                }
            }
            if (c == '-') {
                if (i-1<0 || i+1==s.length() || !(s.charAt(i-1)>='a' &&s.charAt(i-1)<='z')
                      || !(s.charAt(i+1)>='a' &&s.charAt(i+1)<='z')) {
                    return false;
                }
                if (dash) {
                    return false;
                }
                dash = true;
            }
        }
        return true;
    }
}
