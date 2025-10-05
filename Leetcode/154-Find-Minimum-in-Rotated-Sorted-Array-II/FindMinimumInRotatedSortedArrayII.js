/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    var res = nums[0]
    for(var i=1; i<nums.length; i++) {
        res = Math.min(res, nums[i])
    }
    return res
};
