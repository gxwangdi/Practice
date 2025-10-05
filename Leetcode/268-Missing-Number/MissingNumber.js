/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    if (!nums || nums.length == 0) {
        return -1
    }
    var res = 0
    for (var i=0; i<nums.length; i++) {
        res = res ^ nums[i] ^ (i+1)
    }
    return res
};
