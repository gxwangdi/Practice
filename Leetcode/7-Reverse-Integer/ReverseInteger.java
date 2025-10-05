public class ReverseInteger {
    public int reverse(int x) {
      int m = Math.abs(x);
      long total = 0;
      while (m>0) {
          int mod = m%10;
          total = total*10 + mod;
          m = m/10;
      }
      if (total > Integer.MAX_VALUE) {
          return 0;
      }
      if (x<0) {
          total *= -1;
      }
      return (int)total;
    }
}
