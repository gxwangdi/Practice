
Hardcode a map char to integer, indicating all the carries.

Scan from the last char, this is the key! 
if char[i+1] <= char[i], plus the value the char represents;
else, minus the value.
