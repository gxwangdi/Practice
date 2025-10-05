
Get count of the nodes when initializing.       

map the double value from Math.random() to the range of 0...count. 

Space O(1) despite the original data strucutre, Time O(n).  

Pay Attention to the boundary case !     

Note that for Math.random()*len, when len ==2 it is not equal probability to be 0 or 1. 
Better to use java.util.Random.nextInt(len);   



  