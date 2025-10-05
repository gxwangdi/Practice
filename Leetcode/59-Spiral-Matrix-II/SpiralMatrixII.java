public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        generateMatrix(res, 0, n, 1);
        return res;
    }
    
    private void generateMatrix(int[][] res, int start, int length, int count) {
        if (length <= 0) {
            return;
        }
        if (length == 1) {
            res[start][start] = count;
            return;
        }
        int i = start;
        int j = start;
        while (j < start + length - 1) {
            res[i][j] = count++;
            j++;
        }
        
        while (i < start + length -1) {
            res[i][j] = count++;
            i++;
        }
        
        while (j > start) {
            res[i][j] = count++;
            j--;
        }
        
        while (i > start) {
            res[i][j] = count++;
            i--;
        }
        generateMatrix(res, start+1, length-2, count);
    }
}



