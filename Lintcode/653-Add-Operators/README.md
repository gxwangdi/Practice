
This is basically a search problem.

For each recursion, prepare the prefix sum, the progress stringbuilder, for '+', '-' or '*' , try each or them and proceed. at the end of the string, compare the prefix sum and the target. If it is, then add the progress into result set.

Pay attention to how it deals with '*', how multed is changed based on symbols.

And how it deals with range number

