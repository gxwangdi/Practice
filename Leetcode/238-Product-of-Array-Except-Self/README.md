
Basically prepare two arrays,   
f[i] for forward,  means  the product from nums[0] to nums[i-1],  
b[j] for back, means the product from nums[nums.length-1] to nums[j+1]   

So for result res[i] = f[i] * b[i];   
Space O(n),  Time O(n)        

// Note: Looks like this does not care about overflow, so product of int is ok to be int, not long. If I set it to long[], some wired compiling error would happen. 
======================================================
Can I solve it without extra space?      Actually we can init res[] when init f[], and fully fledge res[] when init b[], and only use a pointer to keep record of the latest progress. 

Space O(1) (excludes res[])   Time O(n)
======================================================
Read discussion and found an amazing recursive solution.   

  

