/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    if (!nums || nums.length == 0) {
        return 0
    }
    var i=0
    var j=0
    while (j<nums.length) {
        if (nums[j]!=val) {
            nums[i] = nums[j]
            i++
        }
        j++
    }
    return i
};

