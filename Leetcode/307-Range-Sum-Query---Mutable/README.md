
Besides brute force approach, a normal way is to use prefix sum.    

Let Sum[i] = Sum{A 0....i} 

Sum[i, j] = Sum[j] - Sum[i-1].    The problem is, it takes O(n) for every single update operation, good thing is rangeSum is O(n)  
================================================

Well, organize the data in the form of segment tree, then O(logn) for both update and rangeSum.    

================================================
Well, it looks like binary index tree is something with more concise implementation, I found something here:
https://discuss.leetcode.com/topic/31599/java-using-binary-indexed-tree-with-clear-explanation   

/**
	 * Binary Indexed Trees (BIT or Fenwick tree):
	 * https://www.topcoder.com/community/data-science/data-science-
	 * tutorials/binary-indexed-trees/
	 * 
	 * Example: given an array a[0]...a[7], we use a array BIT[9] to
	 * represent a tree, where index [2] is the parent of [1] and [3], [6]
	 * is the parent of [5] and [7], [4] is the parent of [2] and [6], and
	 * [8] is the parent of [4]. I.e.,
	 * 
	 * BIT[] as a binary tree:
	 *            ______________*
	 *            ______*
	 *            __*     __*
	 *            *   *   *   *
	 * indices: 0 1 2 3 4 5 6 7 8
	 * 
	 * BIT[i] = ([i] is a left child) ? the partial sum from its left most
	 * descendant to itself : the partial sum from its parent (exclusive) to
	 * itself. (check the range of "__").
	 * 
	 * Eg. BIT[1]=a[0], BIT[2]=a[1]+BIT[1]=a[1]+a[0], BIT[3]=a[2],
	 * BIT[4]=a[3]+BIT[3]+BIT[2]=a[3]+a[2]+a[1]+a[0],
	 * BIT[6]=a[5]+BIT[5]=a[5]+a[4],
	 * BIT[8]=a[7]+BIT[7]+BIT[6]+BIT[4]=a[7]+a[6]+...+a[0], ...
	 * 
	 * Thus, to update a[1]=BIT[2], we shall update BIT[2], BIT[4], BIT[8],
	 * i.e., for current [i], the next update [j] is j=i+(i&-i) //double the
	 * last 1-bit from [i].
	 * 
	 * Similarly, to get the partial sum up to a[6]=BIT[7], we shall get the
	 * sum of BIT[7], BIT[6], BIT[4], i.e., for current [i], the next
	 * summand [j] is j=i-(i&-i) // delete the last 1-bit from [i].
	 * 
	 * To obtain the original value of a[7] (corresponding to index [8] of
	 * BIT), we have to subtract BIT[7], BIT[6], BIT[4] from BIT[8], i.e.,
	 * starting from [idx-1], for current [i], the next subtrahend [j] is
	 * j=i-(i&-i), up to j==idx-(idx&-idx) exclusive. (However, a quicker
	 * way but using extra space is to store the original array.)
	 */

