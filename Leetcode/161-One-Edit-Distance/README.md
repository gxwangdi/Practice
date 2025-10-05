
For the definition of edit distance, check here:
https://leetcode.com/problems/edit-distance/   
Anyway since this is just one edit distance, so it should not need to get the min edit distance, which means, that introduces unnecessary overhead to this problem. 


When inconsistency happens, we will just check the situation that only qualifies for one edit distance.  
1) Replace 1 char:
 	  s: a B c
 	  t: a D c
2) Delete 1 char from s: 
	  s: a D  b c
	  t: a    b c
3) Delete 1 char from t
	  s: a   b c
	  t: a D b c

It asks for exactly one edit distance, not less than one edit distance !     
