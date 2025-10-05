public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // n = Math.abs(n);
        String s = Integer.toBinaryString(n);
        s = s.replaceAll("0", "");
        return s.length();
    }
}