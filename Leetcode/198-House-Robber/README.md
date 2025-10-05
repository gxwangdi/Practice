
Well, straight forward manner would do it.  

As it is pick one at every other home style, so it is just to see odd or even makes the most.   As 1,3,5 ....  is bigger than 3, 5 ......   

Space O(1), Time O(n)     
=======================================
Well, above turns out does not work, as it could choose every three element to build a max. Switch to dynamic programming.  

max[i] means the max to the ith position. 
So
max[0] = nums[0];  
max[1] = Math.max(nums[0], nums[1]);      
max[i] = Math.max(max[i-1], max[i-2] + nums[i]);        

Space O(n)   Time O(n)      