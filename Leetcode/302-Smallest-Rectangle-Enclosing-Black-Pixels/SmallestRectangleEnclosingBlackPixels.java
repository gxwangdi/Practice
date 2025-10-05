public class SmallestRectangleEnclosingBlackPixels {
    
    private final char one = '1';
    private final char zero = '0';
    
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int colMin = binarySearch(image, true, 0, y, 0, m, true);
        int colMax = binarySearch(image, true, y+1, n, 0, m, false);
        int rowMin = binarySearch(image, false, 0, x, colMin, colMax, true);
        int rowMax = binarySearch(image, false, x+1, m, colMin, colMax, false);    
        
        return (rowMax - rowMin) * (colMax - colMin);
    }// end of minArea     
    
    public int binarySearch(char[][] image, boolean horizontal, int lower, int upper, int min, int max, boolean goLower) {
        while (lower < upper) {
            int mid = lower + (upper - lower)/2;
            boolean inside = false;
            for (int i=min; i<max; i++) {
                if((horizontal ? image[i][mid] : image[mid][i]) == '1') {
   				    inside = true; 
   				    break;
   			    }
   	    	}
		    if(inside == goLower) {
			    upper = mid;
		    } else {
			    lower = mid + 1;
		    }
        }
        return lower;
    }
    
    
    /*
    // BFS, assuming the given point could be anywhere and not necessarily one end of a point. Gets MLE.   
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0) {
            return 0;
        }
        int m = image.length;
        int n = image[0].length;
        // Assuming <x,y> is always easy. 
        int lowR = x;
        int highR = x;
        int lowC = y;
        int highC = y;
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();
        row.offer(x);
        column.offer(y);
        while (!row.isEmpty()) {
            int i = row.poll();
            int j = column.poll();
            image[i][j] = zero;
            if (i > 0 && image[i-1][j] == one) {
                row.offer(i-1);
                column.offer(j);
                lowR = Math.min(lowR, i-1);
            }
            if (i<m-1 && image[i+1][j] == one) {
                row.offer(i+1);
                column.offer(j);
                highR = Math.max(highR, i+1);
            }
            if (j>0 && image[i][j-1] == one) {
                row.offer(i);
                column.offer(j-1);
                lowC = Math.min(lowC, j-1);
            }
            if (j<n-1 && image[i][j+1] == one) {
                row.offer(i);
                column.offer(j+1);
                highC = Math.max(highC, j+1);
            }
        }
        return (highR-lowR+1) * (highC-lowC+1);
    }
    */
}





