Note : This is a good example that partial optimization is not necessarily global optimization.
Greedy does not work, and we will need to collect all result and get the minimum at every level.

This looks like a search problem.

for i = Math.sqrt(n) to 1, let n-i^2 to be the new i, and i to be the new ceiling, along the progress, to proceed as a next level recursion.

If it is a fit, meaning the new n is 0, then return progress, or, just return -1.

