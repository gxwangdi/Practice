
For input [3, 2, -5, 4, 1] , first of all, build a sum array,  [3, 5, 0, 4, 5]  

Then 4-3 means 1...3.    In this way we put a range with uncertain number of elements into pair [lower, upper].   

Then we build a balanced binary search tree, with node like: 