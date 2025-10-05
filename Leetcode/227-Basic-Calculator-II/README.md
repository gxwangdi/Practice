
I will remove all the space first.   

For each iteration, will keep the last symbol if it is + or -, and the last number, and the prefix result.    

For each iteration, if the symbol has a higher priority, pop the last iteration by reversing the operation and the last number.   

Can I assume each number only takes one char?  No.     
====================================================

Found an iterative approach in discuss, 
https://discuss.leetcode.com/topic/17435/java-straight-forward-iteration-solution-with-comments-no-stack-o-n-o-1/2  

Pay attention to how it deals with preVal and curVal.     

 