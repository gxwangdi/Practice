For category 0, two pointers left and right.

left moves from head to tail, and stays on space that is not 0,

right moves from tail to head. and stays on space that is 0.

and swap elements in left and right, left++ and right -- to make progress. When the two crosses, then right is reset to tail position, and left stay, raise cur to start next category until left steps out of the boundary.

Space O(1), Time O(nm), n is the size of the array, m is the number of categories, 3 for this case.      



