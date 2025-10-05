
Normally  we will need to split a segment into two point, one start and one end.  

start inserts the height into a maxHeap, end removes the height from the maxHeap.  priorityQueue has remove API, it should be O(1) if the underneath implementation is hashHeap, or it might take O(logn).  

Space O(n).  Time O(n).   

   