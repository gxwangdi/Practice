public class ExcelSheetColumnNumber {
    
    public int titleToNumber(String s) {
        if (s == null) {
            return -1;
        }
        if (s.length()<1) {
            return 0;
        }
        int total = 0;
        for (int i=0; i<s.length(); i++) {
            total = total*26;
            total += s.charAt(i)-'A'+1;
        }
        return total;
    }// end of titleToNumber           
    
}




