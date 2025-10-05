
Well, need to talk to interviewer and clarify enough before proceeding !

first missing positive means, if the array is 4,5,7,8 then the answer should be 1, not 6!

In this way, we can map index and value. Put value to position which equals to the index, and check the first inconsistent one.

basically we map 
0->1
1->2
2->3 .... As 0 does not count as positive number.

Space O(1), Time O(n).

