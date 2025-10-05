
It takes duplicates into account, basically will need to use a map to keep record of frequencies, rather than a set.      

Space O(min(nums.length, nums2.length))    Time O( nums.length + nums2.length )