public class AdditiveNumber {
    /*
    public boolean isAdditiveNumber(String num) {
        if (num==null || num.length()<=2)
            return false;
        
        //[0, 1] is first number, [i+1, j] is second number, [j+1 and end] is remaining
        for (int i=0; i<(num.length()-1)/2; i++) {
            for (int j=i+1; num.length()-j-1>=Math.max(i+1, j-1); j++) {
                if (isValid(num.substring(0, i+1), num.substring(i+1, j+1), num.substring(j+1)))
                    return true;
            }
        }
        return false;
    }// end of isAdditiveNumber          
    
    public boolean isValid(String num1, String num2, String remain) {
        if (remain.isEmpty()) return true;
        if (num1.charAt(0) == '0' && num1.length()>1) return false;
        if (num2.charAt(0) == '0' && num2.length()>1) return false;
        String sum = String.valueOf(Long.parseLong(num1) + Long.parseLong(num2));
        
        if (!remain.startsWith(sum)) return false;
        
        return isValid(num2, sum, remain.substring(sum.length()));
    }
    */
    public boolean isAdditiveNumber(String num) {
    if (num == null || num.length() <= 2) return false;

    //[0,i] is first number, [i+1,j] is second number,[j+1 any end is remaining]
    // Once the first two are determined, the left part is determined. 
    for (int i = 0; i < (num.length() - 1) / 2; i++) {
        for (int j = i + 1; num.length() - j - 1 >= Math.max(i + 1, j - i); j++) {
            int offset = j + 1;
            String num1 = num.substring(0, i + 1), num2 = num.substring(i + 1, j + 1);

            while (offset < num.length()) {
                if (num1.charAt(0) == '0' && num1.length() > 1) break;
                if (num2.charAt(0) == '0' && num2.length() > 1) break;
                String sum = String.valueOf(Long.parseLong(num1) + Long.parseLong(num2));
                if (!num.startsWith(sum, offset)) break;

                num1 = num2;
                num2 = sum;
                offset += sum.length();
            }
            if (offset == num.length()) return true;
        }
    }
    return false;
}
}