
Well, basically search the right range in a recursive manner.
if (start == cur.start && end == cur.end) return max.

mid = (start + end)>>1;

If end <= mid go to left child;

If start > mid go to right child;

If start <=mid <end max (query(cur.left, start, mid), query(cur.right, mid+1, end))

Time O(logn). Space O(logn) basically the size of the system stack.

