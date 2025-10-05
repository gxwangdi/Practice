/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    if (!nums || nums.length == 0) {
        return 0
    }
    var res =0
    for (i in nums) {
        res ^= nums[i]
    }
    return res
};


