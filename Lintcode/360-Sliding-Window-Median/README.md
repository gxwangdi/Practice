
In Java, PriorityQueue supports heap functions and random remove!

So basically we will need to setup minHeap and maxHeap, maintaining their size so that maxHeap size <= minHeap size <= maxHeap size+1.

When cur>= k+1, start to put maxHeap.peek() into result set.

Pay attention to the index change for the removing element.

