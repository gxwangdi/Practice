public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean isPlus = true;
        int i=0;
        if (str.charAt(i)=='-') {
            isPlus = false;
            i++;
        } else if (str.charAt(i)=='+') {
            i++;
        }
        double result = 0;
        while (i<str.length()) {
            if (str.charAt(i)>='0' && str.charAt(i)<='9') {
                result = result*10 +(str.charAt(i)-'0');
            } else {
                break;
            }
            i++;
        }
        if (!isPlus) {
            result = 0-result;
        }
        if (result>Integer.MAX_VALUE) 
            return Integer.MAX_VALUE;
        if (result<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)result;
    }
}