/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    var res = []
    var p=1
    res.push(1)
    for (var i=1; i<nums.length; i++) {
        p*=nums[i-1]
        res.push(p)
    }

    p=1
    for (var i=nums.length-2; i>=0; i--) {
        p*=nums[i+1]
        res[i]*=p
    }
    return res
};
