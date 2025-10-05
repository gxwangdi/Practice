/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
    if (!nums || nums.length == 0) {
        return 1
    }

    for (var i=0; i<nums.length; i++) {
        if (nums[i] <= 0) {
            continue
        }
        if (nums[i] > nums.length) {
            continue
        }
        if (nums[nums[i]-1] == nums[i]) {
            continue
        }
        var temp = nums[i]
        nums[i] = nums[temp-1]
        nums[temp-1] = temp
        i--
    }

    for (var i=0; i<nums.length; i++) {
        if (nums[i] != i+1) {
            return i+1
        }
    }
    return nums.length+1
};
