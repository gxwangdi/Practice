public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char cur = t.charAt(0);      
        for (int i=1; i<t.length(); i++) {
            cur = (char)(cur^t.charAt(i));
        }
        for (int i=0; i<s.length(); i++) {
            cur = (char)(cur^s.charAt(i));
        }
        return cur;
    }// end of findTheDifference
}// end of Solution 





