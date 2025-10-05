public class RegularExpressionMatching {
    
    /* // Java API is accepted. 
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return s.matches(p);
    }*/ 
    
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        
        if (p.length()==1 || p.charAt(1)!='*') {
            if (s.isEmpty() || (p.charAt(0)!='.' && p.charAt(0)!=s.charAt(0)) ) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        
        while ( !s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') ) {
            if ( isMatch(s, p.substring(2)) ) {
                return true;
            }
            s = s.substring(1);
        }
        
        return isMatch( s, p.substring(2) );
    }
    
    
    
    
    /* // recursive two pointers approach, does not work for now.
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s, 0, p, 0);
    }
    
    private boolean isMatch(String s, int sCur, String p, int pCur) {
        if (pCur == p.length()) {
            return sCur == s.length();
        }
        
        if (pCur+1 == p.length() || p.charAt(pCur+1)!='*') {
            if (sCur == s.length() || p.charAt(pCur)!='.' && p.charAt(pCur)!=s.charAt(sCur)) {
                return false;
            } else {
                return isMatch(s, sCur+1, p, pCur+1);
            }
        }
        
        while ( sCur+1<=s.length() && (s.charAt(sCur)==p.charAt(pCur) || p.charAt(pCur) == '.')) {
            if (isMatch(s, sCur, p, pCur+2)) {
                return true;
            }
            sCur++;
        }
        
        return isMatch(s, sCur, p, pCur);
    }*/
    
    /* // my implementation does not handle this:  "aaa" "a*a" 
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int i = 0;
        int j = 0;
        while ( i<s.length() && j<p.length() ) {
            if ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                i++;
                j++;
            } else if (p.charAt(j) == '*') {
                j--;
            } else if (j+1<p.length() && p.charAt(j+1)=='*') {
                j += 2;
            } else {
                return false;
            }
        }
        if (i < s.length()) {
            return false;
        }
        while (j<p.length()) {
            if (p.charAt(j)!='*') {
                if (j == p.length()-1 || (j+1<p.length()&&p.charAt(j+1) != '*')) {
                    return false;
                } 
            }
            j++;
        }
        return true;
    }
    */
}




