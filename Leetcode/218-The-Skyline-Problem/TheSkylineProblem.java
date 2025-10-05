import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();          
        List<int[]> height = new ArrayList<>();       
        
        for (int[] arr:buildings) {
            height.add(new int[]{arr[0], -arr[2]});
            height.add(new int[]{arr[1], arr[2]});
        }
        
        // Collections.sort(height, new Comparator<int[]>(){
        //     public int compare(int[] a, int[] b) {
        //         if (a[0] != b[0]) {
        //             return a[0]-b[0];
        //         }
        //         return a[1]-b[1];
        //     }
        // });
        // Java 8
        Collections.sort(height, (a,b)->{
            if (a[0] != b[0]) {
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        
        // Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Java 8 
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        maxHeap.offer(0);
        int prev = 0;
        for (int[] h:height) {
            if (h[1]<0) {
                maxHeap.offer(-h[1]);
            } else {
                maxHeap.remove(h[1]);
            }
            int cur = maxHeap.peek();
            if (prev != cur) {
                res.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return res;
    }// end of getSkyline
}



