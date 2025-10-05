
This is basically the reverse process of negative-positive partition.

i from start to tail and when it meets continuously second negative, stop, j from tail to start, when it meets continuously second positive stop.

if (i > j) exit;
else swap(i, j), and reset counter for pointer i and j.

