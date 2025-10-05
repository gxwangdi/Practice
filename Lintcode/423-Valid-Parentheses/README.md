
Remove "()" "[]" "{}" round and round, until the length of the string does not change.

See if the length is 0. O(n2)

Using a stack, and check the string from head to the tail, push when getting '(', '[' or '{', pop and compare couple when getting ')', ']' or '}' respectively.

