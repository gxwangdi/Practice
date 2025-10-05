public class ValidNumber {
    
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.length()==0) {
            return false;
        }
        int start = 0;
        int end = s.length()-1;
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        }
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        while (start <= end) {
            char c = s.charAt(start);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (exp || dot) {
                    return false;
                }
                dot = true;
            } else if (c == 'e') {
                if (exp || !num) {
                    return false;
                }
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(start-1)!='e') {
                    return false;
                }
            } else {
                return false;
            }
            start++;
        }
        return num;
    }
    
    /*
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.length()==0) {
            return false;
        }
        boolean isDot = false;
        boolean isE = false;
        int start = 0;
        while (start < s.length() && s.charAt(start)=='0') {
            start++;
        }
        for (int i=start; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (isDot) {
                    return false;
                } else {
                    isDot = true;
                    continue;
                }
            }
            if (c == 'e') {
                if (isE) {
                    return false;
                } else {
                    if (i == start) {
                        return false;
                    }
                    isE = true;
                    continue;
                }
            }
            if (c < '0' || c > '9') {
                return false;
            }
        }
        s = s.replaceAll("e", "");
        s = s.replaceAll("\\.", "");
        return s.length()>0;
    }
    */
}



