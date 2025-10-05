
Basically binary search, make 2D into linear structure in that, assuming m*n, let A = i*m+j  be the mapping in a linear structure.       

then track elements in 2D as [A/m][A%m].    

Space O(1), Time O(log(mn)).       

========================= Pay CLOSE attention to index change and physical meaning!  