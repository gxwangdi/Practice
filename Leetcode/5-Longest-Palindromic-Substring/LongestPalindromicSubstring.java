

public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
      if (s == null || s.length() <2) {
          return s;
      }
      int[] res = new int[]{-1,-1};
      int len = 0;
      for (int i=0; i<s.length(); i++) {
          int[] temp = new int[]{i, i};
          int l = getPalindromeLength(s, temp);
          if (l > len) {
              len = l;
              res = temp;
          }
          temp = new int[]{i, i+1};
          l = getPalindromeLength(s, temp);
          if (l > len) {
              len = l;
              res = temp;
          }
      }
      return s.substring(res[0], res[1]+1);
  }

  private int getPalindromeLength(String s, int[] i) {
      while(i[0] >= 0 && i[1] < s.length() && s.charAt(i[0]) == s.charAt(i[1])) {
          i[0] -= 1;
          i[1] += 1;
      }
      i[0] +=1;
      i[1] -=1;
      return i[1]-i[0]+1;
  }
    // public String longestPalindrome(String s) {
    //     if (s == null || s.length() < 2) {
    //         return s;
    //     }
    //     String res = "";
    //     String temp;
    //     for (int i=0; i<s.length()-1; i++) {
    //         temp = getLongestPalindrome(s, i, i);
    //         if (temp.length() > res.length()) {
    //             res = temp;
    //         }
    //         temp = getLongestPalindrome(s, i, i+1);
    //         if (temp.length() > res.length()) {
    //             res = temp;
    //         }
    //     }
    //     return res;
    // }
    //
    // private String getLongestPalindrome(String s, int start, int end) {
    //     while (start >=0
    //         && end <s.length()
    //         && s.charAt(start) == s.charAt(end)) {
    //         start--;
    //         end++;
    //     }
    //     start++;
    //     end--;
    //     if (start <= end) {
    //         return s.substring(start, end+1);
    //     }
    //     return "";
    // }
}
