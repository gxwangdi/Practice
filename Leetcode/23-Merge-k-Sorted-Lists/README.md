
1. merge sort approach
Can simulate merge sort, in that split the list into equally two parts, and merge.   

Space O(logn),   Time O(nlogn)   

2. heap sort approach
Define a heap, and put all elements into the heap, and poll one by one.   

Space O(n)  Time O(nlogn)

This requires to master three approaches, divide and conquer, heap, merge two by two!  

divide and conquer is like top->bottom,  two by two is like bottom->top.  

3. heap sort 2
Maintain a heap with size lists.length. Make sure every linked list have at most one node in the heap.  When it reaches the end we do not need the heap. Note that there could be null ListNode in the input array. 

Space O(k), Time O(nlogk)
