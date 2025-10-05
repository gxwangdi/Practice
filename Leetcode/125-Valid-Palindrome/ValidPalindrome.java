public class ValidPalindrome {
    
    public boolean isPalindrome(String s) {
        if (s==null) {
            return true;
        }
        
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("[^a-z0-9]", "");
        if (s.length() <2) {
            return true;
        }
        int left = 0;
        int right = s.length()-1;
        while (left <right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

