Not sure if it is possible that nums[0] < lower, or nums[len-1] > uppper, if it is possible, need to setup the initial start point.    

Well, just notice that the assumption is stated:
"the range of elements are [lower, upper] inclusive". 

Basically check the element one by one, and if it is missing, add it into result set.   

