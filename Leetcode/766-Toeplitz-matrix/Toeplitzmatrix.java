

class Toeplitzmatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<m; i++) {
            int x =i;
            int y =0;
            int target = matrix[x][y];
            while (x<matrix.length && y<matrix[0].length) {
                if (target != matrix[x][y]) {
                    return false;
                }
                x++;
                y++;
            }
        }
        for (int j=0; j<n; j++) {
            int x =0;
            int y =j;
            int target = matrix[x][y];
            while (x<matrix.length && y<matrix[0].length) {
                if (target != matrix[x][y]) {
                    return false;
                }
                x++;
                y++;
            }
        }
        return true;
    }
}
