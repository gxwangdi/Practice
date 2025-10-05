
1. for the loop condition, need to validate both i and j are valid.
2. in the return, i and j should arrive at the end of word and abbr respectively.
3. in case single digit number, i3 should start from i2, not i2+1.
4. at the end of i3 loop, i3 stays at the next digit of number substring.
5. i1 + len > word.length(), not >=. Just in case the last char are numbers in abbr.
6. use Character.isDigit(char) will simplify the impl.
7. when using continue to bypass iterations, start from simple case.
