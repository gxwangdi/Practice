
Basically using 2D prefix sum, init takes O(n^2), but in the actul processing, we use a map to match existing value, for each row diff, in this way we spend O(n^2) space and reduce the Time to O(n^2).

