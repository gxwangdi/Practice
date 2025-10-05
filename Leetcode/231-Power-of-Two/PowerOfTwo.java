public class PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
      if (n<=0) {
          return false;
      }
      String s = Integer.toBinaryString(n);
      s = s.replaceAll("0", "");
      return s.equals("1");
  }
}
