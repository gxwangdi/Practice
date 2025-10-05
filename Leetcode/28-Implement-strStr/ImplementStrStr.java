public class ImplementStrStr {
    /*  // KMP, O(m+n)
    public int strStr(String haystack, String needle) {
        
    }*/
    
    /* // RM O(m+n)
    public int strStr(String haystack, String needle) {
        
    }*/ 
    
    /* // Sunday O(m+n) 
    public int strStr(String haystack, String needle) {
        
    }*/
    
    /* 
    // Change a string to a double and compare two doubles in O(1).  
    // Sliding window moves in haystack, only think of O(m+n).        
    public int strStr(String haystack, String needle) {
        
    }*/
    
    // naive solution
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        
        for (int i=0; i+needle.length()<= haystack.length(); i++) {
            int j=0;
            for (j=0; j<needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
    
    /*  // Convert string to integer first. The hash would read every char when sliding window moves forward, so O(nm).   
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length())
            return -1;
            
        Set<String> set = new HashSet<>();
        set.add(needle);
        for (int i=0; i<=haystack.length()-needle.length(); i++) {
            if (set.contains(haystack.substring(i, i+needle.length())))
                return i;
        }
        return -1;
    }*/
    
    /* // Java API 
    public int strStr(String haystack, String needle) {
        if (haystack == null) 
            return -1;
        return haystack.indexOf(needle);
    }*/
}




