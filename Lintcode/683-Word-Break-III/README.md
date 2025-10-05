Recursive DFS search could be the most straight forward approach for this problem.

For each iteration, we have S, start_index, max_length, and dict. return 1 if there is a solution, 0 if not.

Accumulate all true solutions at the root.

To reduce backtracing as much as possible, maybe we can build a trie like structure.

To avoid unnecessary search, we set a maxLength, which is the maxLength of strings in dict.

