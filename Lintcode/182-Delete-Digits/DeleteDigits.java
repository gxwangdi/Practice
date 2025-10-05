import java.util.Stack;


public class DeleteDigits {
	/**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    // Stack
    public String DeleteDigits(String A, int k) {
		if (A == null || A.length() <= k) {
			return "";
		}
		Stack<Integer> stack = new Stack<>();
		int deleted = 0;
		for (int i = 0; i < A.length(); i++) {
			int cur = A.charAt(i) - '0';
			while (!stack.isEmpty() && stack.peek() > cur && deleted < k) {
				deleted++;
				stack.pop();
			}
			stack.push(cur);
		}
		while (deleted < k) {
			deleted++;
			stack.pop();
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
    
    /* // DP approach
    public String DeleteDigits(String A, int k) {
        if (A == null || A.length() <= k) {
            return "";
        }
        int[][] dp = new int[A.length()][k+1];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = Integer.parseInt(A.substring(0,i+1));
                } else if (i < j) {
                    dp[i][j] = 0;
                } else {
                    int cur = dp[i-1][j] * 10 + Integer.parseInt(A.substring(i, i+1));
                    dp[i][j] = Math.min(cur, dp[i-1][j-1]);
                }
            }
        }
        return String.valueOf(dp[A.length()-1][k]);
    }*/
}
