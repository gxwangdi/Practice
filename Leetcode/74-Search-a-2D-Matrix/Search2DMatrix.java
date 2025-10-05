public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
        //     return false;
        // }
        int left = 0;
        int right = m*n-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int midX = mid/n;
            int midY = mid%n;
            if (matrix[midX][midY] == target) {
                return true;
            }
            // if (mid == left) {
            //     return false;
            // }
            if (matrix[midX][midY] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }// end of searchMatrix
}







