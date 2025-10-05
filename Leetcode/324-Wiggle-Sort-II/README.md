
I do not see any difference between this and WiggleSort......

Well, this could result in duplicate value, and only check/swap adjacent elements does not work.     

input:   [1,2,2,1,2,1,1,1,1,2,2,2]           
output: [1,2,1,2,1,2,1,1,1,2,2,2]                    
＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
One way is we can sort it first, and let i=1, j=len-1, switch nums[i] and nums[j], and i +=2, j-=2; until i>=j.   

Sorting takes O(nlogn), Space O(1)

===================================================
Have not figured out O(n), reference this posting:
https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java/2    

Have not figured out index mapping.  but an easier to understand solution with O(n) Space will do the trick.  

Well, this definitely qualifies for a Hard problem +_+     

  
