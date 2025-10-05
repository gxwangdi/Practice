
public class FindTheMissingNumberII {
	/**
     * @param n an integer
     * @param str a string with number from 1-n
     *            in random order and miss one number
     * @return an integer
     */   
    public boolean flag = false;
    public int ans = 0;
    public int findMissing2(int n, String str) {
        boolean[] happen = new boolean[n + 1];
        dfs(0, n, str, happen);
        return ans;
    }
    
    public void dfs(int i, int n, String s, boolean[] happen) {
        if (i >= s.length() || flag) {
        	if (!flag)
            for (int k = 1; k <= n; k++) {
                if (!happen[k]) {
                    ans = k;
                }
            }
        	flag = true;
            return;
        }
        int sum = s.charAt(i) - '0';
        int j = i;
        if (sum == 0) {
            return;
        }
        while (sum <= n) {
            if (!happen[sum]) {
                happen[sum] = true;
                dfs(j+1, n, s, happen);
                happen[sum] = false;
            }
            j++;
            if (j >= s.length()) {
                break;
            }
            sum = sum * 10 + (s.charAt(j) - '0');
        }
    }
}
