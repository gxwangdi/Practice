public class ExcelSheetColumnTitle {
    // Take AB as an example to run through it. 
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        if (n<0) {
            isNegative = true;
            n = Math.abs(n);
        }
        
        while (n!=0) {
            sb.append((char)('A'+(n-1)%26));
            n = (n-1) /26;
        }
        if (isNegative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }// end of convertToTitle    
}


