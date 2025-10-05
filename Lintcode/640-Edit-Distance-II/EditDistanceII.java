
public class EditDistanceII {
	/**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        int sL = s.length();
        int tL = t.length();
        if (Math.abs(sL - tL) > 1 || s.equals(t)) {
            return false;
        }
        if (sL == tL) {
            return isOneEdit(s, t);
        }
        
        return sL>tL? isOneRemove(s,t) : isOneRemove(t, s);
    }// end of isOneEditDistance
    
    private boolean isOneEdit(String s, String t) {
        boolean edited = false;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (edited) {
                    return false;
                }
                edited = true;
            }
        }
        return true;
    }
    
    private boolean isOneRemove(String s, String t) {
        boolean edited = false;
        int i = 0;
        int j = 0;
        int sL = s.length();
        int tL = t.length();
        while (i < sL && j < tL) {
            if (s.charAt(i) != t.charAt(j)) {
                i++;
                if (edited) {
                    return false;
                }
                edited = true;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
