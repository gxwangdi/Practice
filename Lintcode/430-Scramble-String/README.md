
This is a little bit different from anagram, in that it is not totally out of order, char swap is based on neighbourhood.    

If S1 and S2 are scramble strings,  then there must be an int k, which splits S1 into [0...k] as S11 and [k+1...S1.length-1] as S12, and same for S2, so that (S11, S21), (S12, S22) are both scramble strings, OR (S11, S22) and (S12, S21) are scramble strings.   

In this way we can use recursive approach. 
For dp approach, we then define the define the state d[k](i)[j] as whether the string s1[i...i+k] and s2[j...j+k] are scramble. We then have the formula:

d[k][i][j] = true; if for any l that 1<=l<=k-1, we have:  1. d[l][i][j] && d[k-l][i+l][j+l]  ||  2. d[l][i][j+k-l] && d[k-l](i+l)[j];

Otherweise d[k](i)[j] = false.

Given solution is based on DP. 
