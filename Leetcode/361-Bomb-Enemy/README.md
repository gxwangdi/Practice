
Looks like I will need to create two 2D dp matrix.   

column[i][j] means how many enemies I can kill at most on column j, if I put a bomb at i,j.  

row[i][j] means how many enemies  I can kill at most on row i, if I put a bomb at i,j.  

init would take O(n^2).    

answer would be max value in dp[i][j].  
＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
Looks like difficult to organize dp array. Reference a posting in discuss, 
https://discuss.leetcode.com/topic/48742/simple-dp-solution-in-java    
and it is inevitable. It only recompute row and col when it is on the starting point or it faces a wall. 

  

