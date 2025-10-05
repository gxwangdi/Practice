import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {
    
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[] array = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            update(matrix, i, array);
            max = Math.max(max, findMax(array));
        }
        return max;
    }
    
    public void update(char[][] matrix, int row, int[] array) {
        int m = array.length;
        for (int i = 0; i < m; i++) {
            array[i] = matrix[row][i] == '0' ? 0 : 1 + array[i];
        }
    }
    
    public int findMax(int[] array) {
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        int max = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (stack.peek() == -1 || array[i] >= array[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.peek() != -1 && array[stack.peek()] > array[i]) {
                    int h = array[stack.pop()];
                    int l = stack.peek();
                    int r = i;
                    max = Math.max(max, h * (r - l - 1));
                }
                stack.push(i);
            }
        }
        
        while (stack.peek() != -1) {
            int h = array[stack.pop()];
            int l = stack.peek();
            int r = array.length;
            max = Math.max(max, h * (r - l - 1));
        }
        
        return max;
    }
    
    /*
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        //bool dp[m][n][m+1][n+1];
        boolean[][] dp = new boolean[2][n+1];
        int maxRectangle = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j]=='0') {
                    continue;
                }
                for (int xLen=1; i+xLen-1<m; xLen++) {
                    for (int yLen=1; j+yLen-1<n; yLen++) {
                        if (matrix[i+xLen-1][j+yLen-1] == '0') {
                            dp[0][yLen] = false;
                            break;
                        }
                        if (xLen == 1 && yLen == 1) {
                            //dp[i][j][xLen][yLen] = true;
                            dp[1][yLen] = true;
                        } else if (xLen == 1 && yLen != 1) {
                            //dp[i][j][xLen][yLen] = dp[i][j][xLen][yLen-1];
                            dp[1][yLen] = dp[1][yLen-1];
                        } else if (xLen != 1 && yLen == 1) {
                            dp[1][yLen] = dp[0][yLen];
                        } else {
                            dp[1][yLen] = dp[1][yLen-1] && dp[0][yLen];
                        }
                        if (dp[1][yLen]) {
                            maxRectangle = Math.max(xLen * yLen,maxRectangle);
                            dp[0][yLen] = dp[1][yLen];
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return maxRectangle;
    }// end of maximalRectangle        
    */
}





