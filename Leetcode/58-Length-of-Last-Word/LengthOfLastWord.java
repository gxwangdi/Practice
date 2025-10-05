public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length()<1)
            return 0;
            
        int res = 0;
        int an = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (res != 0)
                    an = res;
                res = 0;
            } else {
                res ++;
            }
        }
        if (res!=0)
            return res;
        return an;
    }
    
    /*
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length()<1)
            return 0;
        
        String[] arr = s.split("[ ]+");
        return arr[arr.length-1].length();
    }*/
}