public class ReverseString {
    public String reverseString(String s) {
        if (s == null || s.length()<2) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i=s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }// end of reverseString        
}

