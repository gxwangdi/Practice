
Set up a window and move from the beginning to the end and check if there is a match.

for i< j < k, if Aj < Ak, we move one step at this iteration, or we move two.

O(1) space O(n) time. 
Above algorithm does not work, as it assumes that i, j , k are sequential index, actually they are not.

So take the last number as iterator, traverse the array from tail to the beginning. 
O(n^2)

  

