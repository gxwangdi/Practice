
Firstly get the max value in array L, which is the end.

start is 0.

Last/Biggest length that can get >=k piece.

To check how many piece could it be, brute force.

Do not think of there is any optimize solution, if no special characters applied.

Well, couple of edge cases: 
1. If L is invalid, return 0;
2. Sum of all elements in L is less than k, return 0;
3. start is init as 1.

