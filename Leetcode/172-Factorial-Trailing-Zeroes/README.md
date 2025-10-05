
Use some simple example and easily observe that,  10 is from 2 and 5, for any n>5,  among n!, the amount of 2 far exceeds the amount of 5.    So the number of 5 is the answer.  

Note that 25 has two 5s, 125 has three 5s, so No. of 5s in n! is 
floor(n/5) + floor(n/25) + floor(n/125)  ......  

Space O(1)   Time O(logn)    