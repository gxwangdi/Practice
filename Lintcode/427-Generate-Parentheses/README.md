

This is like level order traversal, then return nodes in the last level.

Basically if A is a valid string, then the next level valid string would be ()A, (A), and A(). Need to verify if there is duplicate inside. Using a set to speed up.

Space O(3,n), Time O(3, n+1).
This is a recursive approach.

PAY ATTENTION to the condition:
if (left > right) {
return;
}
to exclude invalid case like ")("

