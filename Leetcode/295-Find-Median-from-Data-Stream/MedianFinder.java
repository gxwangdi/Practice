import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(10);
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        if (maxHeap.size() > minHeap.size() +1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if (size ==0) {
            return Double.MIN_VALUE;
        }
        if (size%2 == 1) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek())/2.0f;
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();




