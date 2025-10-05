
Check every single cell, if it is land, result +=4, assuming all neighbors are water;
Check the top and left neighbors, if the neighbor is land, result -=2, remove the common edge for both cell.

Note that how it avoids duplicate removal by only checking top and left, not all four directions.
