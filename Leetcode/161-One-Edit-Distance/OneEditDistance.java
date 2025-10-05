public class OneEditDistance {
    
    
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int min = Math.abs(s.length() - t.length());
        if (min > 1) {
            return false;
        }
        int len = Math.min(s.length(), t.length());
        for (int i=0; i<len; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                continue;
            }
            if (min == 0) { // s.length() == t.length(), then replace chars in both strings
                return s.substring(i+1).equals(t.substring(i+1));
            }
            if (s.length() > t.length()) { // delete one char from s
                return s.substring(i+1).equals(t.substring(i));
            } else { // delete one char from t
                return t.substring(i+1).equals(s.substring(i));
            }
        }
        return min == 1;
    }
}






