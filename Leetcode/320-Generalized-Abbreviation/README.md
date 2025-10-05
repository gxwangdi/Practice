
Reference a posting in discuss,  which renders a very simple approach:

For each char c[i], either abbreviate it or not.
This comes to the pattern:
int len = sb.length(); // decision point
... backtracking logic ...
sb.setLength(len);     // reset to decision point     

