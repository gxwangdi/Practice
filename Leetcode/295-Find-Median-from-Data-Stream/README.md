
Maintain a maxHeap, and a minHeap.  Maintain heap size like  minHeap.size() <= maxHeap.size() <= minHeap.size()+1

If maxHeap.size() + minHeap.size() is even, then return maxHeap.peek();
else  return (maxHeap.peek() + minHeap.peek())/2.0f.   

