
The one that should be flip is that do not connect with 0s on the boundary. So start from 0s on the boundary, do a BFS, and mark all 0s to something else, like 'Y';

Then scan the whole matrix, flip all remaining 0s;

Scan the whole matrix and flip Ys to Os.

Space O(n), Time (n^2).

