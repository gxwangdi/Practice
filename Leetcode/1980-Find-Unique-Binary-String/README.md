
A straight forward solution.

One can think of it this way, for n, each digit should have 2^n-1 1s. Traverse every string and calculate, then assemble missing 1 digits into the new string. 

Keep in mind that the return string should have length of n, so need to append '0' upfront as necessary.
