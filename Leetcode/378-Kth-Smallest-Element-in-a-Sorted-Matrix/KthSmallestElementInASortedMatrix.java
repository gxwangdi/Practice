import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInASortedMatrix {
    
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Queue<Tuple> minHeap = new PriorityQueue<>();
        for (int j=0; j<=n-1; j++) {
            minHeap.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i=0; i<k-1; i++) { 
            // pop k-1 iteration from min heap
            Tuple t = minHeap.poll();
            if (t.x == n-1) continue;
            minHeap.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        // This is the kth min element.   
        return minHeap.poll().val;
    }// end of kthSmallest           
    
    private static class Tuple implements Comparable<Tuple> {
        public int x;
        public int y;
        public int val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        public int compareTo(Tuple t) {
            return this.val - t.val;
        }
    }// end of Tuple class        
}










