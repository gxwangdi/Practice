
Basically we can setup an boolean array size n, and tag accordingly while we scan the nums array.

Space O(n), Time O(n)

If we could change nums array, will need to put value i to the ith position, use index as mappings. And check one by one which one has incosistent value/index.

Space O(1), Time O(n)

NOTE: question can vary, make sure you understand the value scope and the index scope,
value 0...n-1 map index 0...n-1, and left n alone.


=====================================
Actually we can set result and xor with [0...N], and xor with all numbers in the array. The left one is what is missing.   

Time O(n), Space O(1). 

