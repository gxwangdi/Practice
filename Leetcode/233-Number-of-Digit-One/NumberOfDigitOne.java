public class NumberOfDigitOne {
    
    public int countDigitOne(int n) {
        if (n < 1) {
            return 0;
        }
        return NumberOf1(n+"");
    }
    
    private int NumberOf1(String n) {
        
        int len = n.length();
        int first = n.charAt(0) - '0';
        
        if (len == 1 && first == 0) {
            return 0;
        }
        if (len == 1 && first > 0) {
            return 1;
        }
        
        // Assuming n is "21345" 
        // numFirstDigit is the amount of first digit among 10000~19999
        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = PowerBase10(len -1);
        } else if (first == 1) {
            numFirstDigit = Integer.valueOf(n.substring(1)) +1;
        }
        
        // numOtherDigits is the amount of 1s in all digits except the first digit among 1346~21345.
        int numOtherDigits = first *(len-1) *PowerBase10(len-2);
        // numRecursive is the amount of 1s among 1~1345
        int numRecursive = NumberOf1(n.substring(1)); //
        
        return numFirstDigit + numOtherDigits + numRecursive;
    }
    
    private int PowerBase10(int n) {
        int result = 1;
        for (int i=0; i<n; i++) {
            result *=10;
        }
        return result;
    }
    
    /*
    // Brute force would get a TLE here
    public int countDigitOne(int n) {
        int count = 0;
        if (n<1) {
            return count;
        }
        for (int i=1; i<=n; i++) {
            count += countOne(i);
        }
        return count;
    }// end of countDigitOne       
    
    private int countOne(int n) {
        int res = 0;
        while (n!=0) {
            if (n%10 == 1) {
                res++;
            }
            n = n/10;
        }
        return res;
    }
    */
}




