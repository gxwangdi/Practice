
The binary search template is like:

left
right
while left+1<right
  mid = left + (right-left)/2
  if some logic
    left = mid(+1 if aggregate more aggressively)
  else
    right = mid(-1 if aggregate more aggressively)

check left
check right
return missing.

In this case, it would never stop progressing, it would never dead loop. 
