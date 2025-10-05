/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    if (!nums || nums.length<2) {
        return false
    }
    nums.sort()
    for (var i=0; i<nums.length-1; i++) {
        if (nums[i]==nums[i+1]) {
            return true
        }
    }
    return false
};
