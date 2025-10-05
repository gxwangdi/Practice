/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    var i = 0
    if (!nums || nums.length < 1) {
        return i
    }
    var j = i+1
    var cur = nums[i]
    while (j < nums.length) {
        if (nums[j] != cur) {
            i++
            nums[i] = nums[j]
            cur = nums[i];
        }
        j++
    }
    return i+1
};


