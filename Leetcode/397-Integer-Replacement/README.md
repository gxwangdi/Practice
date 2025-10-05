
// Given 1, see how many times it needs <<1 to exceed n.   

Well, for easy problem, go straight along the description is fine. Now we need to figure out when to +1 and when to -1.   

13 = 1101
If we plus one, we can get 1110; if we reduce one, we can get 1100;
1110 needs 2+2+1 = 5 steps, while 1100 only needs 2+1+1 = 4 steps, so we choose n-1 in this step.




