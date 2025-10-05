

Use the top-left point as starting point, for all other points in the same island, only record the delta (row - currRowOrigin, col - currColOrigin).  

Note that for a pair of ints, only Pair class can be properly calculated hashCode based on <K,V> value, int[] does not work.

Set<Pair> can be calculated hashCode properly based on values.
