
Based on longest common substring, every time we found a matching char pair between A and B, we would like to check previous paird chars.

My solution tracks back to get maxSum and introduce O(mn), overall complexity reaches O(m2n2).

jiuzhang`s solution delivers the maxSum along the dp array, and removes the duplicate check. O(mn)

