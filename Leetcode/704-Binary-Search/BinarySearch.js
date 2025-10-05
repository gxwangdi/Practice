/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    if (!nums || nums.length < 1) {
        return -1
    }
    var left =0
    var right = nums.length-1
    while (left+1<right) {
        var mid = left+Math.floor((right-left)/2)
        if(nums[mid]==target) {
            return mid
        }
        if (nums[mid]<target) {
            left = mid+1
            continue
        }
        right = mid-1
    }
    if (nums[left] == target) {
        return left;
    }
    if (nums[right] == target) {
        return right;
    }
    return -1
};
