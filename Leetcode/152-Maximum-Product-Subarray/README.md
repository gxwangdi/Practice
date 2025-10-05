
It requires the max product, not the index, so learn to use the max(x, 0) or similar technique to cut res set, and we only care about the temp max product, or temp min product.   

NOTE:
pay attention to the edge case, all temp vars should be initialized as nums[0], and compare with current nums[i] in each iteration.  

