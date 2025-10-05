
All char will be in input string.

Prepare an array with size 256, representing the earliest index for [a-z].   

initially all are -2.  Read through the string char by char, and check corresponding array element for redundancy. 

If array element is -2, update the element with current index, if it is an index, update it to -1, if it is -1, ignore. 

At the end, check the array and return min in [0-array.length-1].  

