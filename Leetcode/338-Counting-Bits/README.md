Hints: 
You should make use of what you have produced already.
Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
Or does the odd/even status of the number help you in calculating the number of 1s?


As hints are for 2~3, 4~7, will need to manually list 0~15 and see how their binary form changes.    And observe that when it is even, it is like num<<1, and it should have the same amount of 1s as num, if it is odd, it is like num<<1+1, same amount of 1s as num plus 1.    So DP[i] = func(DP[i/2]), which is the hard part for DP.  

i&(i-1) ==0 is used to check if a number is a power of 2, now it works in this way after manually listing from 0~15:  

 
i    bin       '1'    i&(i-1)
0    0000    0
-----------------------
1    0001    1    0000
-----------------------
2    0010    1    0000
3    0011    2    0010
-----------------------
4    0100    1    0000
5    0101    2    0100
6    0110    2    0100
7    0111    3    0110
-----------------------
8    1000    1    0000
9    1001    2    1000
10   1010    2    1000
11   1011    3    1010
12   1100    2    1000
13   1101    3    1100
14   1110    3    1100
15   1111    4    1110