
Basically two pointers for the last two dimensions, left and right.   

Space O(1), Time O(n3) 
================================================

Map approach would store index pair for i and j,  key is the balance.    Well, build the map takes Space O(n2), Time O(n2),   and the k, l match takes Time O(n2).   Overall O(n2).    

PAY ATTENTION to the way it removes duplicate elements in the result set. 



  