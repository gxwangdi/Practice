class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int valid = 0;
        int i = 0;
        for (i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                valid +=1;
            }
            if (s.charAt(i) == ')') {
                valid -=1;
            }
            if (valid < 0) {
                return false;
            }
        }
        if (valid == 0) {
            return true;
        }
        valid = 0;
        for (i -= 1; i>=0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                valid +=1;
            }
            if (s.charAt(i) == '(') {
                valid -=1;
            }
            if (valid < 0) {
                return false;
            }
        }
        return true;
    }
}
