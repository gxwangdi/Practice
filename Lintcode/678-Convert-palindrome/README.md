
Setup a pointer from left to right, actually to the middle of the string is good enough.
And check if it can reach the beginning of the string. If it can, update the position.

Based on the position marked on first round, multiply two and get the length of the longest palindrome. If the number is equal or bigger than the str`s length, then return the original one.
If smaller than str'length, reverse it and append to the left of the original string, that is the answer.

Given is a simplified way to implement the basic idea.   
