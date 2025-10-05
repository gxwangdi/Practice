
Naive solution would be to list i from 1 to n, until i*i > n. Space O(1) Time O(n1/2).   

It could be to find a number i in range 0~n, such that i*i is closest to n, or equals to n. 

This is binary search.  Time O(logn).       

O(1) solution is introduced here:   https://en.wikipedia.org/wiki/Fast_inverse_square_root.    



    