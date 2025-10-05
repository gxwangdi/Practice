
public class Count1InBinary {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    // Java API.
    /*
    public int countOnes(int num) {
        // write your code here
        String s = Integer.toBinaryString(num);
        
        s = s.replaceAll("0", "");
        return s.length();
    }*/
    // Numeric manner
    public int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
};