
If k is bigger than nums.length, note that k = x*nums.length + y, it is actually y that counts.    

Prepare [nums.length-k, nums.length-1] as a window, move the window at one time. 

Space O(k)   Time O(n)    
=========================Solution from Online     Space O(1)  Time O(n)  
Assuming we are given {1,2,3,4,5,6} and order 2. The basic idea is:
1. Divide the array two parts: 1,2,3,4 and 5, 6
2. Reverse first part: 4,3,2,1,5,6
3. Reverse second part: 4,3,2,1,6,5
4. Reverse the whole array: 5,6,1,2,3,4

