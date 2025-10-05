
Build the skeleton first, and track the random pointer, and find it in the new list, which takes O(n) each iteration. It has O(n) iterations, so O(n2) solution.

Algorithm below is from the book coding interveiw: Space O(1), Time O(n)
1. Insert the same node after the original node;
2. If random pointer is not null, then peer node`s random pointer is the next;
3. Separate the two list.

This looks like inspired by monacher algorithm.

