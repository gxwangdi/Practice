public class SearchA2DMatrixII {
    
    // Search online and find a simple implementation, which has O(m+n) solution. 
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int i = 0;
        int j = matrix[0].length -1;
        while (i < matrix.length && j >=0) {
            int temp = matrix[i][j];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
    
    /*   
    // Code half way and realize that this solution requires too much coding!  Need to figure out better solution.
    // Space O(1)   Time O(nlogm) 
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        
        int i = getLowerRange(matrix, target);
        if (i == -1) {
            return false;
        }
        
        int j = getUpperRange(matrix, target, i);
        if (j == -1) {
            return false;
        }
        
        for (int row = j; row <= i; row++) {
            int temp = binarySearch(matrix[row], target);
            if (temp != -1) {
                return temp;
            }
        }
        return -1;
    }// end of searchMatrix   
    
    private int getLowerRange(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (matrix[mid][0] == target) {
                return mid;
            }
            if (matrix[mid][0] > target) {
                if (mid == right) {
                    return right;
                } else {
                    right = mid -1;
                }
            } else {
                if (mid == left) {
                    return left;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    
    private int getUpperRange(int[][] matrix, int target, int upper) {
        // TODO: 
    }
    
    private int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }
    */
}