import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        if (triangle == null || triangle.size() == 0) {
            return min;
        }
        int[][] dp = new int[triangle.size()][];
        for (int i=0; i<triangle.size(); i++) {
            dp[i] = new int[triangle.get(i).size()];
        }
        
        dp[0][0] = triangle.get(0).get(0);
        for (int i=1; i<triangle.size(); i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        
        for (int i=2; i<triangle.size(); i++) {
            for (int j=1; j<triangle.get(i).size()-1; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
        }
        for (int i:dp[triangle.size()-1]) {
            min = Math.min(min, i);
        }
        return min;
    }
}





