
Initially set count as 1,   pivot as nums[0]    cur pointer starts from 1.  

if pivot < cur    count++, and if count == 3, return true;
if pivot > cur   pivot = cur, count =1;

return false if after a one round scanning. 
===========================================
Looks like something wrong in correctness proof.  Maybe we will need a dp array,  dp[i] means how many numbers smaller than num[i].  

Well, brute force is just taking O(n^2), doubt if it worths the effort.      
===========================================

Reference discussion, it is just asking for 3, not 4, 5 or bigger.   
set a small, if cur is smaller than small, update small, and set a big, if cur is smaller than big,  update big, if it is bigger than both big or small, then we get it.   

O(1) space,   O(n) time.  


