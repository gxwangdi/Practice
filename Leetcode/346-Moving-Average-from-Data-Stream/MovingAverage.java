import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    private int capacity;
    private Queue<Integer> q;
    private long sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<>();
        if (size >0) {
            capacity = size;
        } else {
            capacity = 1;
        }
        sum = 0;
    }
    
    public double next(int val) {
        sum += val;
        q.offer(val);
        if (q.size() > capacity) {
            int out = q.poll();
            sum -= out;
        }
        return ((double)sum)/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */