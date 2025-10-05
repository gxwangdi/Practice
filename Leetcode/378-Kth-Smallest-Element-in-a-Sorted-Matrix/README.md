
Every line is sorted,  every column is sorted. But there is no relationship between row and row, column and column.    

Well, cannot figure out how to use the sorted order.      Reference a posting in discuss:   
https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-clean-java-code/2     

The min element is matrix[0][0], put all the min elements of all columns into a min heap first, which are the elements in first row.  Then for every element popped up from the heap, put the element in the next row into heap.       

 
