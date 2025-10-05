First of all, XOR all elements in the array, the outcome is (a xor b), where a and b is the final result. find the first 1 bit in the outcome, and separate the array into two arrays, one array has all the elements that are 1 in the bit, while another has all the elements that are 0 in the bit.

And find a b respectively in the two arrays.

Be careful about this: 
((i>>count)&1) == 1 == has higher priority than &.

