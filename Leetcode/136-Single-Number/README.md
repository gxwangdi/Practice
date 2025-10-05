
xor bool table is like:

^ | 0 1      ^ | F T
--+-----     --+-----
0 | 0 1      F | F T
1 | 1 0      T | T F     

SO the single one will remain after xor all elements in the array.    

Space O(1), Time O(n)   

